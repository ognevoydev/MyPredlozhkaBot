package com.ognevoydev.mypredlozhkabot.service.reply.factory;

import com.ognevoydev.mypredlozhkabot.model.Media;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;

@Getter
@RequiredArgsConstructor
public abstract class PartialMethodFactory<T extends PartialBotApiMethod<?>> {

    private final Media.MediaType mediaType;

    public abstract T generate(Media media, long chatID);

}