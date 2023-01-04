package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.MessageHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.UpdateHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Component
public class UpdateHandlerImpl implements UpdateHandler {

    @Autowired
    private MessageHandler messageHandler;

    @Override
    public Optional<Reply<?>> handle(Update update) {
        if(update.hasMessage()) {
            Message message = update.getMessage();
            return messageHandler.handle(message);
        }
        else return Optional.empty();
    }
}
