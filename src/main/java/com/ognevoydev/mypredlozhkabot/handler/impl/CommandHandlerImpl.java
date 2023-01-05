package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.*;
import static com.ognevoydev.mypredlozhkabot.utils.generator.ReplyGenerator.generateReply;

@Component
public class CommandHandlerImpl implements CommandHandler {

    @Override
    public Reply<SendMessage> startCommandReceived(long chatId) {
        return generateReply(START_REPLY, chatId);
    }

    @Override
    public Reply<SendMessage> helpCommandReceived(long chatId) {
        return generateReply(HELP_REPLY, chatId);
    }

    @Override
    public Reply<SendMessage> unknownCommandReceived(long chatId) {
        return generateReply(UNKNOWN_REPLY, chatId);
    }

}
