package com.ognevoydev.mypredlozhkabot.handler.impl.post;

import com.ognevoydev.mypredlozhkabot.confg.BotConfig;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import com.ognevoydev.mypredlozhkabot.service.reply.ReplyFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.ognevoydev.mypredlozhkabot.model.mapper.Mapper.messageToMedia;

@Component
public class MainPostHandler implements PostHandler {

    private final long adminId;

    private final ReplyFactory replyFactory;

    public MainPostHandler(BotConfig config, ReplyFactory replyFactory) {
        this.adminId = config.getAdminId();
        this.replyFactory = replyFactory;
    }

    @Override
    public Reply<?> handle(Message message) {
        return replyFactory.generate(messageToMedia(message), adminId);
    }

}