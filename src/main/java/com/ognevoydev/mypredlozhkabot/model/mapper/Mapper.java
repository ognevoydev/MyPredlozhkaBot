package com.ognevoydev.mypredlozhkabot.model.mapper;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.ADMIN_POST_REPLY;
import static com.ognevoydev.mypredlozhkabot.model.Media.MediaType.*;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.getMaxSizePhoto;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.getMediaType;

public class Mapper {

    private static final Map<Media.MediaType, Function<Message, InputFile>> RECEIVE_MESSAGE_DATA_FUNCTIONS = Map.of(
            PHOTO, (message) -> {
                List<PhotoSize> photos = message.getPhoto();
                return new InputFile(getMaxSizePhoto(photos));
            },
            VIDEO, (message) -> {
                String video = message.getVideo().getFileId();
                return new InputFile(video);
            },
            ANIMATION, (message) -> {
                String animation = message.getAnimation().getFileId();
                return new InputFile(animation);
            }
    );

    public static Media messageToMedia(Message message) {
        String caption = String.format(ADMIN_POST_REPLY, message.getChat().getFirstName());

        Media.MediaType mediaType = getMediaType(message);
        Function<Message, InputFile> receiveInputFile = RECEIVE_MESSAGE_DATA_FUNCTIONS.get(mediaType);
        if (receiveInputFile == null)
            throw new UnsupportedOperationException(
                    "Receive file from message with %s media type is unsupported yet."
                            .formatted(mediaType));

        return new Media(caption, receiveInputFile.apply(message), mediaType);
    }

}
