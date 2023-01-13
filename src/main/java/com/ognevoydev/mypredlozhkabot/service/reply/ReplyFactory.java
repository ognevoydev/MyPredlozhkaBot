package com.ognevoydev.mypredlozhkabot.service.reply;

import com.ognevoydev.mypredlozhkabot.model.Media;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import com.ognevoydev.mypredlozhkabot.service.reply.factory.PartialMethodFactory;
import com.ognevoydev.mypredlozhkabot.service.reply.factory.SendMessageFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ReplyFactory {

    private final SendMessageFactory sendMessageFactory;
    private final Map<Media.MediaType, PartialMethodFactory<?>> partialMethodFactories;

    public ReplyFactory(SendMessageFactory sendMessageFactory,
                        List<PartialMethodFactory<?>> partialMethodFactories) {
        this.sendMessageFactory = sendMessageFactory;
        this.partialMethodFactories = partialMethodFactories.stream()
                .collect(Collectors.toMap(PartialMethodFactory::getMediaType, Function.identity()));
    }

    public Reply<SendMessage> generate(String message, long chatID) {
        return generate(message, chatID, null);
    }

    public Reply<SendMessage> generate(String message, long chatID, Integer userMessageID) {
        return new Reply<>(sendMessageFactory.generate(message, chatID, userMessageID));
    }

    public Reply<?> generate(Media media, long chatID) {
        return new Reply<>(partialMethodFactories.get(media.getType()).generate(media, chatID));
    }

}