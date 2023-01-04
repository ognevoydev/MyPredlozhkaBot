package com.ognevoydev.mypredlozhkabot.handler.api;

import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface CommandHandler {
    Reply<SendMessage> startCommandReceived(long chatId);
    Reply<SendMessage> helpCommandReceived(long chatId);
    Reply<SendMessage> unknownCommandReceived(long chatId);
}
