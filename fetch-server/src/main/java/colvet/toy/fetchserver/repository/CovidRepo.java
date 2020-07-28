package colvet.toy.fetchserver.repository;

import colvet.toy.fetchserver.data.CovidDataItem;
import colvet.toy.fetchserver.model.CovidDataResponseModel;
import org.json.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepo extends MongoRepository<CovidDataItem, String> {

}
