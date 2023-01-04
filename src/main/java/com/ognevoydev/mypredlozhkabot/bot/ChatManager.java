package com.ognevoydev.mypredlozhkabot.bot;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.POST_REPLY;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.generateMessage;

@Slf4j
@Component
public class ChatManager {

    public void sendMessage(MyPredlozhkaBot bot, Reply<?> message, Message userMessage) {
        try {
            send(bot, message, userMessage);
        }
        catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
    }

    private void send(MyPredlozhkaBot bot, Reply<?> message, Message userMessage) throws TelegramApiException{
        if(message.getMessage().getClass().equals(SendMessage.class)) {
            bot.execute((SendMessage) message.getMessage());
        }
        else {
            if(message.getMessage().getClass().equals(SendPhoto.class)) {
                bot.execute((SendPhoto) message.getMessage());
            }
            if(message.getMessage().getClass().equals(SendVideo.class)) {
                bot.execute((SendVideo) message.getMessage());
            }
            if(message.getMessage().getClass().equals(SendMediaGroup.class)) {
                bot.execute((SendMediaGroup) message.getMessage());
            }
            long chatId = userMessage.getChatId();
            int userMessageId = userMessage.getMessageId();
            bot.execute(generateMessage(POST_REPLY, chatId, userMessageId).getMessage());
        }
    }

}
