package colvet.toy.fetchserver.controller;

import colvet.toy.fetchserver.service.CovidDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class OpenApiController {

    @Autowired
    CovidDataService fetchCovidDataService;

    @Value("${open.api.key}")
    private String apiKey;

    private static final String covidUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson";


    @GetMapping("/fetchdata")
    public String fetch() throws IOException {

       fetchCovidDataService.fetchCovidData();


        return "Success";
    }
}
