package colvet.toy.fetchserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    Environment environment;

    @GetMapping("/status/check")
    public String status(){
        return String.format("This project port is : %s ", environment.getProperty("local.server.port"));
    }
}
