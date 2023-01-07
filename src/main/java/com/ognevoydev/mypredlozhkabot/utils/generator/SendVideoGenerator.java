package com.ognevoydev.mypredlozhkabot.utils.generator;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;

public class SendVideoGenerator {

    public static SendVideo generate(Media media, long adminId) {
        SendVideo sendVideo = new SendVideo();
        sendVideo.setVideo(media.getFile());
        sendVideo.setChatId(adminId);
        sendVideo.setCaption(media.getCaption());

        return sendVideo;
    }
}
