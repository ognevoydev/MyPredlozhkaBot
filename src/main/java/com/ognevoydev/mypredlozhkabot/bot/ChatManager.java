package com.ognevoydev.mypredlozhkabot.bot;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class ChatManager {

    public void sendMessage(MyPredlozhkaBot bot, Reply<?> message) {
        try {
            send(bot, message);
        }
        catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
    }

    private void send(MyPredlozhkaBot bot, Reply<?> message) throws TelegramApiException{
        if(message.getMessage().getClass().equals(SendMessage.class)) {
            bot.execute((SendMessage) message.getMessage());
        }
        if(message.getMessage().getClass().equals(SendPhoto.class)) {
            bot.execute((SendPhoto) message.getMessage());
        }
        if(message.getMessage().getClass().equals(SendVideo.class)) {
            bot.execute((SendVideo) message.getMessage());
        }
        if(message.getMessage().getClass().equals(SendMediaGroup.class)) {
            bot.execute((SendMediaGroup) message.getMessage());
        }
    }

}
