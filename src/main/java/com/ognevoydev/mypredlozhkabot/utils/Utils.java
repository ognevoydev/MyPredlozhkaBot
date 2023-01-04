package com.ognevoydev.mypredlozhkabot.utils;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Utils {

    public static Reply<SendMessage> generateMessage(String message, long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        return generateReply(sendMessage);
    }

    public static Reply<SendMessage> generateMessage(String message, long chatId, int userMessageId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyToMessageId(userMessageId);

        return generateReply(sendMessage);
    }

    public static Reply<SendMessage> generateReply(SendMessage message) {
        Reply<SendMessage> reply = new Reply<SendMessage>();
        reply.setMessage(message);
        return reply;
    }

    public static Reply<SendPhoto> generateReply(SendPhoto message) {
        Reply<SendPhoto> reply = new Reply<SendPhoto>();
        reply.setMessage(message);
        return reply;
    }

    public static Reply<SendVideo> generateReply(SendVideo message) {
        Reply<SendVideo> reply = new Reply<SendVideo>();
        reply.setMessage(message);
        return reply;
    }

    public static boolean isMessageContainsMedia(Message message) {
        return message.hasPhoto() || message.hasVideo();
    }

    public static boolean isMessageContainsText(Message message) {
        return message.hasText();
    }

    public static boolean isMessageContainsPhoto(Message message) {
        return message.hasPhoto();
    }
}
