package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.CommandHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.MessageHandler;
import com.ognevoydev.mypredlozhkabot.handler.api.PostHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.ognevoydev.mypredlozhkabot.constants.Commands.HELP;
import static com.ognevoydev.mypredlozhkabot.constants.Commands.START;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.isMessageContainsMedia;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.isMessageContainsText;

@Component
public class MessageHandlerImpl implements MessageHandler {

    @Autowired
    private CommandHandler commandHandler;
    @Autowired
    @Qualifier("mainPostHandler")
    private PostHandler postHandler;

    @Override
    public Optional<Reply<?>> handle(Message message) {
        if(isMessageContainsMedia(message)) {
            return Optional.of(handleMedia(message));
        }
        if(isMessageContainsText(message)) {
            return Optional.of(handleText(message));
        }
        else return Optional.empty();
    }

    private Reply<?> handleMedia(Message message) {
        return postHandler.handle(message);
    }

    private Reply<SendMessage> handleText(Message message) {
        long chatId = message.getChatId();
        return switch (message.getText()) {
            case START -> commandHandler.startCommandReceived(chatId);
            case HELP -> commandHandler.helpCommandReceived(chatId);
            default -> commandHandler.unknownCommandReceived(chatId);
        };
    }
}
