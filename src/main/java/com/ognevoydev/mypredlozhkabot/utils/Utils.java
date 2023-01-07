package com.ognevoydev.mypredlozhkabot.utils;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.Comparator;
import java.util.List;

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

    public static boolean isSendMessage(Class<?> clazz) {
        return clazz.equals(SendMessage.class);
    }

    public static boolean isSendPhoto(Class<?> clazz) {
        return clazz.equals(SendPhoto.class);
    }

    public static boolean isSendVideo(Class<?> clazz) {
        return clazz.equals(SendVideo.class);
    }

    public static boolean isMediaGroup(String mediaGroupId) {
        return mediaGroupId != null;
    }

    public static String getMaxSizePhoto(List<PhotoSize> photos) {
        photos.sort(Comparator.comparing(PhotoSize::getFileSize).reversed());
        return photos.get(0).getFileId();
    }
}
