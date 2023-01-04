package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@RequiredArgsConstructor
@Component
public class MainPostHandler implements PostHandler {

    @Override
    public Reply<?> handle(Message message) {
        return new Reply<>(); //TODO
    }
}
