package com.ognevoydev.mypredlozhkabot.handler.impl.post;

import com.ognevoydev.mypredlozhkabot.confg.BotConfig;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Media;
import com.ognevoydev.mypredlozhkabot.model.MediaType;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.Comparator;
import java.util.List;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.ADMIN_POST_REPLY;
import static com.ognevoydev.mypredlozhkabot.utils.generator.ReplyGenerator.generateReply;

@Component("photoPostHandler")
public class PhotoPostHandler implements PostHandler {

    private final long adminId;

    public PhotoPostHandler(BotConfig config) {
        this.adminId = config.getAdminId();
    }

    @Override
    public Reply<?> handle(Message message) {
        String caption = String.format(ADMIN_POST_REPLY, message.getChat().getFirstName());

        List<PhotoSize> photos = message.getPhoto();
        InputFile file = new InputFile(getMaxSizePhoto(photos));
        Media media = new Media(file, MediaType.PHOTO);

        return generateReply(media, caption, adminId);
    }

    private String getMaxSizePhoto(List<PhotoSize> photos) {
        photos.sort(Comparator.comparing(PhotoSize::getFileSize).reversed());
        return photos.get(0).getFileId();
    }

}
