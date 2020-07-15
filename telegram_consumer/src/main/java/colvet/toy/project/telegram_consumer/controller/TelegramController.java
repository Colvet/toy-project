package colvet.toy.project.telegram_consumer.controller;

import colvet.toy.project.telegram_consumer.service.TelegramBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelegramController {


    @Autowired
    Environment env;

    @Autowired
    TelegramBotService telegramBotService;

    @GetMapping("/send/{msg}")
    public String sendMessage(@PathVariable String msg){
        telegramBotService.sendMessage(msg);
        return "Send Success";
    }

    @GetMapping("/status/check")
    public String status(){
        return String.format("This project port is : %s ", env.getProperty("local.server.port"));
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
