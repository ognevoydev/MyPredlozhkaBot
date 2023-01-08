package com.ognevoydev.mypredlozhkabot.utils;

import com.ognevoydev.mypredlozhkabot.model.Media;
import com.ognevoydev.mypredlozhkabot.model.MessageType;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.Comparator;
import java.util.List;

import static com.ognevoydev.mypredlozhkabot.model.Media.MediaType.*;
import static com.ognevoydev.mypredlozhkabot.model.MessageType.MEDIA;
import static com.ognevoydev.mypredlozhkabot.model.MessageType.TEXT;

public class Utils {

    public static MessageType getMessageType(Message message) {
        if (message.hasPhoto() || message.hasVideo() || message.hasAnimation()) return MEDIA;
        else return TEXT;
    }

    public static Media.MediaType getMediaType(Message message) {
        if (message.hasPhoto()) return PHOTO;
        if (message.hasVideo()) return VIDEO;
        else return ANIMATION;
    }

    public static String getMaxSizePhoto(List<PhotoSize> photos) {
        return photos.stream().max(Comparator.comparing(PhotoSize::getFileSize))
                .map(PhotoSize::getFileId)
                .orElse(null);
    }

}
