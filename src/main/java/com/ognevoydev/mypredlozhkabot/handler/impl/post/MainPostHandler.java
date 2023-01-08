package com.ognevoydev.mypredlozhkabot.handler.impl.post;

import com.ognevoydev.mypredlozhkabot.confg.BotConfig;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Media;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.ognevoydev.mypredlozhkabot.model.mapper.Mapper.messageToMedia;
import static com.ognevoydev.mypredlozhkabot.utils.generator.ReplyGenerator.generateReply;

@Component("mainPostHandler")
public class MainPostHandler implements PostHandler {

    private final long adminId;

    public MainPostHandler(BotConfig config) {
        this.adminId = config.getAdminId();
    }

    @Override
    public Reply<?> handle(Message message) {
        Media media = messageToMedia(message);
        return generateReply(media, adminId);
    }

}
