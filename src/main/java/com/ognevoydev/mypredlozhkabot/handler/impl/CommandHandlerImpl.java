package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.ognevoydev.mypredlozhkabot.constants.Commands.HELP;
import static com.ognevoydev.mypredlozhkabot.constants.Commands.START;
import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.*;
import static com.ognevoydev.mypredlozhkabot.utils.generator.ReplyGenerator.generateReply;

@Component
public class CommandHandlerImpl implements CommandHandler {

    @Override
    public Reply<SendMessage> handle(Message message) {
        long chatId = message.getChatId();
        return switch(message.getText()) {
            case START -> generateReply(START_REPLY, chatId);
            case HELP -> generateReply(HELP_REPLY, chatId);
            default -> generateReply(UNKNOWN_REPLY, chatId);

        };
    }

}
