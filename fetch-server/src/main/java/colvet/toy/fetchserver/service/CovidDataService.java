package colvet.toy.fetchserver.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;

public interface CovidDataService{
    void fetchCovidData() throws IOException;


}
