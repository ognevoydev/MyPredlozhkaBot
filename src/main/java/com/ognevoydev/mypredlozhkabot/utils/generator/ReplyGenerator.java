package com.ognevoydev.mypredlozhkabot.utils.generator;

import com.ognevoydev.mypredlozhkabot.model.Media;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;

import static com.ognevoydev.mypredlozhkabot.model.MediaType.PHOTO;

public class ReplyGenerator {

    public static Reply<SendMessage> generateReply(String message, long chatId) {
        Reply<SendMessage> reply = new Reply<SendMessage>();
        reply.setMessage(SendMessageGenerator.generate(message, chatId));
        return reply;
    }

    public static Reply<SendMessage> generateReply(String message, long chatId, int userMessageId) {
        Reply<SendMessage> reply = new Reply<SendMessage>();
        reply.setMessage(SendMessageGenerator.generate(message, chatId, userMessageId));
        return reply;
    }

    public static Reply<?> generateReply(Media media, String caption, long adminId) {
        if(media.getType() == PHOTO) {
            Reply<SendPhoto> reply = new Reply<SendPhoto>();
            reply.setMessage(SendPhotoGenerator.generate(media, caption, adminId));
            return reply;
        }
        else {
            Reply<SendVideo> reply = new Reply<SendVideo>();
            reply.setMessage(SendVideoGenerator.generate(media, caption, adminId));
            return reply;
        }
    }
}
