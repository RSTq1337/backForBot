package com.example.demo.other;

import com.example.demo.BotSettings;
import com.example.demo.other.MyBot;
import com.example.demo.repo.CityRepos;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

@Service
public class StuffForBot {

    public static CityRepos repos;

    public static BotSettings settings;

    public StuffForBot(CityRepos repos, BotSettings settings) {
        this.repos = repos;
        this.settings = settings;
    }


    public static TelegramLongPollingBot giveBot(){

        return new MyBot(repos,settings);

    }
}
