package colvet.toy.fetchserver.controller;

import colvet.toy.fetchserver.model.GubunResponseModel;
import colvet.toy.fetchserver.service.CovidDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@Slf4j
public class OpenApiController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/fetchdata")
    public String fetch() throws IOException, ParseException {

       covidDataService.fetchAndSaveCovidData();
        return "Success";
    }

    @GetMapping("/getgubun/{gubun}")
    public ResponseEntity<GubunResponseModel> getCovidDataByGubun(@PathVariable("gubun") String gubun){
        GubunResponseModel responseModel = covidDataService.getCovidDataByGubunAndToday(gubun);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responseModel);
        if(responseModel == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseModel);

        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(responseModel);
        }
    }



}
