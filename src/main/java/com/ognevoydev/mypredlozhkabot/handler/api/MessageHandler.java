package com.ognevoydev.mypredlozhkabot.handler.api;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

public interface MessageHandler {
    Optional<Reply<?>> handle(Message message);
}
