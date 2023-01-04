package com.ognevoydev.mypredlozhkabot.handler.impl.post;

import com.ognevoydev.mypredlozhkabot.confg.BotConfig;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.ADMIN_POST_REPLY;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.generateReply;

@Component("videoPostHandler")
public class VideoPostHandler implements PostHandler {

    private final long adminId;

    public VideoPostHandler(BotConfig config) {
        this.adminId = config.getAdminId();
    }

    @Override
    public Reply<SendVideo> handle(Message message) {
        String caption = String.format(ADMIN_POST_REPLY, message.getChat().getFirstName());

        String video = message.getVideo().getFileId();
        InputFile media = new InputFile(video);

        return generatePost(media, caption, adminId);
    }

    private Reply<SendVideo> generatePost(InputFile media, String caption, long adminId) {
        SendVideo sendVideo = new SendVideo();
        sendVideo.setVideo(media);
        sendVideo.setChatId(adminId);
        sendVideo.setCaption(caption);

        return generateReply(sendVideo);
    }
}
