package com.ognevoydev.mypredlozhkabot.handler.impl;

import com.ognevoydev.mypredlozhkabot.handler.api.UpdateHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import com.ognevoydev.mypredlozhkabot.service.reply.ReplyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

import static com.ognevoydev.mypredlozhkabot.constants.Commands.HELP;
import static com.ognevoydev.mypredlozhkabot.constants.Commands.START;
import static com.ognevoydev.mypredlozhkabot.constants.ReplyMessages.*;
import static com.ognevoydev.mypredlozhkabot.model.mapper.Mapper.messageToMedia;
import static com.ognevoydev.mypredlozhkabot.utils.Utils.getMessageType;

@Component
@RequiredArgsConstructor
public class UpdateHandlerImpl implements UpdateHandler {

    private final ReplyFactory replyFactory;

    @Override
    public Optional<Reply<?>> handle(Update update, long adminId) {
        Message message = update.getMessage();
        return switch (getMessageType(message)) {
            case MEDIA -> Optional.of(handle(message, adminId));
            case TEXT -> Optional.of(handle(message));
        };
    }

    private Reply<?> handle(Message message, long adminId) {
        return replyFactory.generate(messageToMedia(message), adminId);
    }

    private Reply<?> handle(Message message) {
        return switch (message.getText()) {
            case START -> replyFactory.generate(START_REPLY, message.getChatId());
            case HELP -> replyFactory.generate(HELP_REPLY, message.getChatId());
            default -> replyFactory.generate(UNKNOWN_REPLY, message.getChatId());
        };
    }

}