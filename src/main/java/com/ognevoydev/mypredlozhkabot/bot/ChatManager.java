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
import static com.ognevoydev.mypredlozhkabot.utils.Utils.*;
import static com.ognevoydev.mypredlozhkabot.utils.generator.ReplyGenerator.generateReply;

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
        if(isSendMessage(message.getMessage().getClass())) {
            bot.execute((SendMessage) message.getMessage());
        }
        else {
            if(isSendPhoto(message.getMessage().getClass())) {
                bot.execute((SendPhoto) message.getMessage());
            }
            if(isSendVideo(message.getMessage().getClass())) {
                bot.execute((SendVideo) message.getMessage());
            }
//            if(isMediaGroup(userMessage.getMediaGroupId())) {
//                bot.execute((SendMediaGroup) message.getMessage());
//            }
            long chatId = userMessage.getChatId();
            int userMessageId = userMessage.getMessageId();
            bot.execute(generateReply(POST_REPLY, chatId, userMessageId).getMessage());
        }
    }

}
