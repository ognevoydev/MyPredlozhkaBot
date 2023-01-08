package com.ognevoydev.mypredlozhkabot.constants;

public interface ReplyMessages {

    String START_REPLY = """
            Привет! Здесь ты можешь отправить пост, который, в случае одобрения,\
            будет опубликован в канале. Бот принимает посты только с картинками и видео. \
            Для дополнительной информации о боте используй команду /help.
            """;

    String HELP_REPLY = """
            Список доступных команд:
            /start - начать работать с ботом
            /help - получить информацию о боте
            """;

    String UNKNOWN_REPLY = "Бот принимает посты только с картинками или видео.";

    String ADMIN_POST_REPLY = "Прислал %s через @MyPredlozhkaBot.";

    String POST_REPLY = "Ваш пост успешно принят.";

}