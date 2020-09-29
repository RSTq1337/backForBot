package com.example.demo.other;


import com.example.demo.BotSettings;
import com.example.demo.enity.City;
import com.example.demo.repo.CityRepos;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Configuration
public class MyBot extends TelegramLongPollingBot {

    CityRepos repos;
    BotSettings settings;

    public MyBot(CityRepos repos, BotSettings settings) {
        this.repos = repos;
        this.settings = settings;
    }

    @Override
    public void onUpdateReceived(Update update) {
            String command=update.getMessage().getText();
            if(!command.equals("/start")) {
                String description = repos.findByName(command).orElse(new City()).getDescription();
                if (description == null) {
                    description = "К сожалению, мы ничего не знаем про этот город, но вы можете что-нибудь добавить на нашём сайте";
                }
                try {
                    execute(new SendMessage(update.getMessage().getChatId(), description));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public String getBotUsername() {
            return settings.getUsername();
    }

    @Override
    public String getBotToken() {
        return settings.getToken();
    }
}
