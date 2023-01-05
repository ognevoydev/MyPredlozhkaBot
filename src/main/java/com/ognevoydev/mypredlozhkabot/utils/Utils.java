package com.ognevoydev.mypredlozhkabot.utils;

import org.telegram.telegrambots.meta.api.objects.Message;

public class Utils {

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
