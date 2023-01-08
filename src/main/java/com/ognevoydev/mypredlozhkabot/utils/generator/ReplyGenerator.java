package com.ognevoydev.mypredlozhkabot.utils.generator;

import com.ognevoydev.mypredlozhkabot.model.Media;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ReplyGenerator {

    public static Reply<SendMessage> generateReply(String message, long chatId) {
        return new Reply<>(SendMessageGenerator.generate(message, chatId));
    }

    public static Reply<SendMessage> generateReply(String message, long chatId, int userMessageId) {
        return new Reply<>(SendMessageGenerator.generate(message, chatId, userMessageId));
    }

    public static Reply<?> generateReply(Media media, long adminId) {
        switch (media.getType()) {
            case PHOTO -> {
                return new Reply<>(SendPhotoGenerator.generate(media, adminId));
            }
            case VIDEO -> {
                return new Reply<>(SendVideoGenerator.generate(media, adminId));
            }
            default -> {
                return new Reply<>(SendAnimationGenerator.generate(media, adminId));
            }
        }
    }
}
