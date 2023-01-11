package com.ognevoydev.mypredlozhkabot.bot;

import com.ognevoydev.mypredlozhkabot.confg.BotConfig;
import com.ognevoydev.mypredlozhkabot.handler.api.UpdateHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class MyPredlozhkaBot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final UpdateHandler updateHandler;
    private final ChatManager chatManager;

    @Override
    public void onUpdateReceived(Update update) {
        updateHandler.handle(update, config.getAdminId()).ifPresent(message ->
                chatManager.sendMessage(this, message, update.getMessage()));
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