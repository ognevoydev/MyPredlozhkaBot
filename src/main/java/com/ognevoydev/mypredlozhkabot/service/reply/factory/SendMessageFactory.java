package com.ognevoydev.mypredlozhkabot.service.reply.factory;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class SendMessageFactory {

    public SendMessage generate(String message, long chatID, Integer userMessageID) {
        return SendMessage.builder()
                .chatId(chatID)
                .text(message)
                .replyToMessageId(userMessageID)
                .build();
    }

}