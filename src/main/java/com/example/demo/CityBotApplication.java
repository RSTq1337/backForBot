package com.example.demo;

import com.example.demo.other.StuffForBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@SpringBootApplication
public class CityBotApplication  {

    public static void main(String[] args) {

        ApiContextInitializer.init();
        SpringApplication.run(CityBotApplication.class, args);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(StuffForBot.giveBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
