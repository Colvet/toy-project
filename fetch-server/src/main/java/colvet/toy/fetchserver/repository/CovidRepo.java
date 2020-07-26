package colvet.toy.fetchserver.repository;

import colvet.toy.fetchserver.data.CovidDataItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepo extends MongoRepository<CovidDataItem, String> {
    CovidDataItem findAllByUpdateDtRegex(String DtRegex);
}
