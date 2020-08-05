package colvet.toy.fetchserver.controller;

import colvet.toy.fetchserver.data.CovidDataMessage;
import colvet.toy.fetchserver.data.MessageType;
import colvet.toy.fetchserver.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    Environment environment;

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/status/check")
    public String status(){
        return String.format("This project port is : %s ", environment.getProperty("local.server.port"));
    }

    @GetMapping("/send")
    public String sendMessage(){
        CovidDataMessage covidDataMessage = new CovidDataMessage();
        covidDataMessage.setGubun("test");
        covidDataMessage.setMessageType(MessageType.UPDATE);
        covidDataMessage.setDeathCnt(2);
        covidDataMessage.setIncDec(2);
        covidDataMessage.setIsolClearCnt(2);
        covidDataMessage.setIsolIngCnt(2);
        log.info(covidDataMessage.toString());
        kafkaProducer.sendDataEvent(covidDataMessage);

        return "Success";
    }
}
