package colvet.toy.project.telegram_consumer.service;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

public class TelegramBot {

    @PostConstruct
    public void init(){
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();

        try{
            api.registerBot(new TelegramBotService());
        } catch (TelegramApiRequestException ex) {
            ex.printStackTrace();
        }
    }
}
