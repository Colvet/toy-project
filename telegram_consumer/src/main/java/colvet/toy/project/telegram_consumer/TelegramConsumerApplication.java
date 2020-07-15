package colvet.toy.project.telegram_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TelegramConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TelegramConsumerApplication.class, args);
    }

}
