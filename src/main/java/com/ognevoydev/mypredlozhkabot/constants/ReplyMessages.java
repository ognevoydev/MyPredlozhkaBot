package com.ognevoydev.mypredlozhkabot.constants;

public class ReplyMessages {
    public final static String START_REPLY = "" +
            "Привет! Здесь ты можешь отправить пост, который, в случае одобрения, " +
            "будет опубликован в канале. Бот принимает посты только с картинками и видео. " +
            "Для дополнительной информации о боте используй команду /help.";

    public final static String HELP_REPLY =
            """
            Список доступных команд: \s
            /start - начать работать с ботом \s
            /help - получить информацию о боте
            """;

    public final static String UNKNOWN_REPLY = "Бот принимает посты только с картинками или видео.";

    public final static String ADMIN_POST_REPLY = "Прислал %s через @MyPredlozhkaBot.";

    public final static String POST_REPLY = "Ваш пост успешно принят.";
}