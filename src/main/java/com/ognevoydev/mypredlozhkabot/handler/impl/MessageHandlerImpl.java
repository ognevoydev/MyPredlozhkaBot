package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.MessageHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.ognevoydev.mypredlozhkabot.utils.Utils.getMessageType;

@Component
public class MessageHandlerImpl implements MessageHandler {

    @Autowired
    private CommandHandler commandHandler;
    @Autowired
    @Qualifier("mainPostHandler")
    private PostHandler postHandler;

    @Override
    public Optional<Reply<?>> handle(Message message) {
        return switch (getMessageType(message)) {
            case MEDIA -> Optional.of(postHandler.handle(message));
            case TEXT -> Optional.of(commandHandler.handle(message));
        };
    }

}
