package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.*;

@Component
public class CommandHandlerImpl implements CommandHandler {

    @Override
    public Reply<SendMessage> startCommandReceived(long chatId) {
        return generateMessage(START_REPLY, chatId);
    }

    @Override
    public Reply<SendMessage> helpCommandReceived(long chatId) {
        return generateMessage(HELP_REPLY, chatId);
    }

    @Override
    public Reply<SendMessage> unknownCommandReceived(long chatId) {
        return generateMessage(UNKNOWN_REPLY, chatId);
    }

    public static Reply<SendMessage> generateMessage(String message, long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        Reply<SendMessage> reply = new Reply<SendMessage>();
        reply.setMessage(sendMessage);

        return reply;
    }
}
