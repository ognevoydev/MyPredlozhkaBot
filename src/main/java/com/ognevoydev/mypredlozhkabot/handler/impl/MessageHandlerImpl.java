package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.MessageHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.ognevoydev.mypredlozhkabot.utils.Utils.getMessageType;

// TODO refactor
@Component
@RequiredArgsConstructor
public class MessageHandlerImpl implements MessageHandler {

    private final CommandHandler commandHandler;
    private final PostHandler postHandler;

    @Override
    public Optional<Reply<?>> handle(Message message) {
        return switch (getMessageType(message)) {
            case MEDIA -> Optional.of(postHandler.handle(message));
            case TEXT -> Optional.of(commandHandler.handle(message));
        };
    }

}