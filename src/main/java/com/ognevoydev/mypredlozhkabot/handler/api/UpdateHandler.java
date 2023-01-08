package com.ognevoydev.mypredlozhkabot.handler.api;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public interface UpdateHandler {
    Optional<Reply<?>> handle(Update update);
}