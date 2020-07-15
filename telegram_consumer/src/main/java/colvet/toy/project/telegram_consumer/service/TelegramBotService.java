package colvet.toy.project.telegram_consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class TelegramBotService extends TelegramLongPollingBot {

    @Value("${telegram.bot.name}")
    private String telegramBotName;

    @Value("${telegram.bot.key}")
    private String telegramApiKey;

    @Override
    public void onUpdateReceived(Update update) {
        log.info("update: " + update);

    }

    @Override
    public String getBotUsername() {
        return telegramBotName;
    }

    @Override
    public String getBotToken() {
        return telegramApiKey;
    }

    public void sendMessage(String msg){
        SendMessage sendMessage = new SendMessage().setChatId("1055554577").setText(msg);
        try{
            execute(sendMessage);
        }catch (TelegramApiException ex){
            ex.printStackTrace();
        }

    }
}
