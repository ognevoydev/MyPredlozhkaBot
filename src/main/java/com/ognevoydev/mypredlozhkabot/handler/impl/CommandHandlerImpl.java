package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import com.ognevoydev.mypredlozhkabot.service.reply.ReplyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.ognevoydev.mypredlozhkabot.constants.Commands.HELP;
import static com.ognevoydev.mypredlozhkabot.constants.Commands.START;
import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.*;

@Component
@RequiredArgsConstructor
public class CommandHandlerImpl implements CommandHandler {

    private final ReplyFactory replyFactory;

    @Override
    public Reply<SendMessage> handle(Message message) {
        return switch (message.getText()) {
            case START -> replyFactory.generate(START_REPLY, message.getChatId());
            case HELP -> replyFactory.generate(HELP_REPLY, message.getChatId());
            default -> replyFactory.generate(UNKNOWN_REPLY, message.getChatId());
        };
    }

}