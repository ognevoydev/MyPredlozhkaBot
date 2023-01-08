package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.MessageHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.UpdateHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateHandlerImpl implements UpdateHandler {

    private final MessageHandler messageHandler;

    @Override
    public Optional<Reply<?>> handle(Update update) {
        return Optional.ofNullable(update.getMessage())
                .flatMap(messageHandler::handle);
    }

}