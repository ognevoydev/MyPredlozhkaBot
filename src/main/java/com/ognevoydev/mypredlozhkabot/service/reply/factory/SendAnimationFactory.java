package com.ognevoydev.mypredlozhkabot.service.reply.factory;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;

import static com.ognevoydev.mypredlozhkabot.model.Media.MediaType.ANIMATION;

@Component
public class SendAnimationFactory extends PartialMethodFactory<SendAnimation> {

    public SendAnimationFactory() {
        super(ANIMATION);
    }

    public SendAnimation generate(Media media, long chatID) {
        return SendAnimation.builder()
                .chatId(chatID)
                .caption(media.getCaption())
                .animation(media.getFile())
                .build();
    }

}