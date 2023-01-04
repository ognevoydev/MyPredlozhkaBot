package com.ognevoydev.mypredlozhkabot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reply<T> {
    private T message;
}
