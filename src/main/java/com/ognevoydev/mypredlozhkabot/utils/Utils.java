package com.ognevoydev.mypredlozhkabot.utils;

import com.ognevoydev.mypredlozhkabot.model.MediaType;
import com.ognevoydev.mypredlozhkabot.model.MessageType;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.Comparator;
import java.util.List;

import static com.ognevoydev.mypredlozhkabot.model.MediaType.*;
import static com.ognevoydev.mypredlozhkabot.model.MessageType.MEDIA;
import static com.ognevoydev.mypredlozhkabot.model.MessageType.TEXT;

public class Utils {

    public static MessageType getMessageType(Message message) {
        if(message.hasPhoto() || message.hasVideo() || message.hasAnimation())
            return MEDIA;
        else
            return TEXT;
    }

    public static MediaType getMediaType(Message message) {
        if(message.hasPhoto())
            return PHOTO;
        if(message.hasVideo())
            return VIDEO;
        else
            return ANIMATION;
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

    public static boolean isSendAnimation(Class<?> clazz) {
        return clazz.equals(SendAnimation.class);
    }


        public static String getMaxSizePhoto(List<PhotoSize> photos) {
        photos.sort(Comparator.comparing(PhotoSize::getFileSize).reversed());
        return photos.get(0).getFileId();
    }
}
