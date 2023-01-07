package com.ognevoydev.mypredlozhkabot.utils.generator;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;

public class SendAnimationGenerator {

    public static SendAnimation generate(Media media, long adminId) {

        SendAnimation sendAnimation = new SendAnimation();
        sendAnimation.setAnimation(media.getFile());
        sendAnimation.setChatId(adminId);
        sendAnimation.setCaption(media.getCaption());

        return sendAnimation;
    }
}
