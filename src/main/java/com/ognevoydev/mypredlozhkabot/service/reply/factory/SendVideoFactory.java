package com.ognevoydev.mypredlozhkabot.service.reply.factory;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;

import static com.ognevoydev.mypredlozhkabot.model.Media.MediaType.VIDEO;

@Component
public class SendVideoFactory extends PartialMethodFactory<SendVideo> {

    public SendVideoFactory() {
        super(VIDEO);
    }

    public SendVideo generate(Media media, long chatID) {
        return SendVideo.builder()
                .chatId(chatID)
                .caption(media.getCaption())
                .video(media.getFile())
                .build();
    }

}