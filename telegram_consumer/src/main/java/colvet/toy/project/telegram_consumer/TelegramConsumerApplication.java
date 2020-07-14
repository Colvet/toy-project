package colvet.toy.project.telegram_consumer;

import colvet.toy.project.telegram_consumer.service.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
@EnableEurekaClient
public class TelegramConsumerApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi bot = new TelegramBotsApi();
        try {
            bot.registerBot(new TelegramBot());
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }


        SpringApplication.run(TelegramConsumerApplication.class, args);
    }

}
