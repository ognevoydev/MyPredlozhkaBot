package com.ognevoydev.mypredlozhkabot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Reply<T> {

    private T message;

}