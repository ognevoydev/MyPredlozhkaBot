package com.ognevoydev.mypredlozhkabot.service.reply.factory;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static org.telegram.telegrambots.meta.api.methods.ParseMode.MARKDOWN;

@Component
public class SendMessageFactory {

    public SendMessage generate(String message, long chatID, Integer userMessageID) {
        return SendMessage.builder()
                .chatId(chatID)
                .text(message)
                .replyToMessageId(userMessageID)
                .parseMode(MARKDOWN)
                .build();
    }

}