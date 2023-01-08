package com.ognevoydev.mypredlozhkabot.handler.api;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {

    Reply<SendMessage> handle(Message message);

}