package com.ognevoydev.mypredlozhkabot.handler.api;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface PostHandler {

    Reply<?> handle(Message message);

}