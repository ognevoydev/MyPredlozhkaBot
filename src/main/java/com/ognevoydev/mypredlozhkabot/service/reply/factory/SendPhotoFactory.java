package com.ognevoydev.mypredlozhkabot.service.reply.factory;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import static com.ognevoydev.mypredlozhkabot.model.Media.MediaType.PHOTO;

@Component
public class SendPhotoFactory extends PartialMethodFactory<SendPhoto> {

    public SendPhotoFactory() {
        super(PHOTO);
    }

    public SendPhoto generate(Media media, long chatID) {
        return SendPhoto.builder()
                .chatId(chatID)
                .caption(media.getCaption())
                .photo(media.getFile())
                .build();
    }

}