package com.ognevoydev.mypredlozhkabot.utils.generator;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class SendMessageGenerator {

    public static SendMessage generate(String message, long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        return sendMessage;
    }

    public static SendMessage generate(String message, long chatId, int userMessageId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyToMessageId(userMessageId);

        return sendMessage;
    }
}
