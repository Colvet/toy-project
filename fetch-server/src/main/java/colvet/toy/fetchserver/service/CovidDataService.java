package colvet.toy.fetchserver.service;

import colvet.toy.fetchserver.model.GubunResponseModel;

import java.io.IOException;
import java.text.ParseException;

public interface CovidDataService{
    void fetchAndSaveCovidData() throws IOException, ParseException;
    GubunResponseModel getCovidDataByGubunAndToday(String gubun);

}
