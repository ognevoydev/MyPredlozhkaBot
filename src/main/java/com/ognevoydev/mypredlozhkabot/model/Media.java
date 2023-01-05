package com.ognevoydev.mypredlozhkabot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.InputFile;

@Getter
@Setter
@AllArgsConstructor
public class Media {
    InputFile file;
    MediaType type;
}
