package com.ognevoydev.mypredlozhkabot.utils.generator;

import com.ognevoydev.mypredlozhkabot.model.Media;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;

import static com.ognevoydev.mypredlozhkabot.utils.generator.ReplyGenerator.generateReply;

public class SendPhotoGenerator {

    public static SendPhoto generate(Media media, long adminId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(media.getFile());
        sendPhoto.setChatId(adminId);
        sendPhoto.setCaption(media.getCaption());

        return sendPhoto;
    }

}
