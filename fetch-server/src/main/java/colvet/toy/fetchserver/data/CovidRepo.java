package colvet.toy.fetchserver.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepo extends MongoRepository<CovidDataItem, String> {
    CovidDataItem findByGubunAndCreateDt(String gubun, String today);
    CovidDataItem findTopByGubunOrderByCreateDt(String gubun);
}
