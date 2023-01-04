package com.ognevoydev.mypredlozhkabot.bot;

import com.ognevoydev.mypredlozhkabot.confg.BotConfig;
import com.ognevoydev.mypredlozhkabot.handler.api.UpdateHandler;
import com.ognevoydev.mypredlozhkabot.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Component
public class MyPredlozhkaBot extends TelegramLongPollingBot {

    private final BotConfig config;

    @Autowired
    private UpdateHandler updateHandler;
    @Autowired
    private ChatManager chatManager;

    public MyPredlozhkaBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Optional<Reply<?>> message = updateHandler.handle(update);
        message.ifPresent(
                value -> {
                    chatManager.sendMessage(this, value);
                }
        );
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

}