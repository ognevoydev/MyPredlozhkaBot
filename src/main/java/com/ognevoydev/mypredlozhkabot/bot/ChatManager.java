package com.ognevoydev.mypredlozhkabot.bot;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import com.ognevoydev.mypredlozhkabot.service.reply.ReplyFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.POST_REPLY;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatManager {

    private final ReplyFactory replyFactory;

    public void sendMessage(MyPredlozhkaBot bot, Reply<?> message, Message userMessage) {
        try {
            send(bot, message, userMessage);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
    }

    private void send(MyPredlozhkaBot bot, Reply<?> message, Message userMessage) throws TelegramApiException {
        Object messageBody = message.getMessage();
        if (messageBody instanceof BotApiMethod<? extends Serializable> method) {
            bot.execute(method);
        } else if (messageBody instanceof PartialBotApiMethod<? extends Serializable> partialMethod) {
            executePartial(bot, partialMethod);
        } else {
            bot.execute(replyFactory.generate(POST_REPLY, userMessage.getChatId(), userMessage.getMessageId()).getMessage());
        }
    }

    private void executePartial(MyPredlozhkaBot bot, PartialBotApiMethod<? extends Serializable> method) throws TelegramApiException {
        if (method instanceof SendPhoto sendPhoto) {
            bot.execute(sendPhoto);
        } else if (method instanceof SendVideo sendVideo) {
            bot.execute(sendVideo);
        } else if (method instanceof SendAnimation sendAnimation) {
            bot.execute(sendAnimation);
        } else if (method instanceof SendVoice sendVoice) {
            bot.execute(sendVoice);
        } else if (method instanceof SendDocument sendDocument) {
            bot.execute(sendDocument);
        } else if (method instanceof SendVideoNote sendVideoNote) {
            bot.execute(sendVideoNote);
        } else if (method instanceof SendSticker sendSticker) {
            bot.execute(sendSticker);
        } else {
            throw new UnsupportedOperationException("%s partial method is unsupported yet.".formatted(method.getClass().getSimpleName()));
        }
    }

}