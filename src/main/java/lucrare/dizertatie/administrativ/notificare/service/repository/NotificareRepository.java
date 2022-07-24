package lucrare.dizertatie.administrativ.notificare.service.repository;

import lucrare.dizertatie.administrativ.notificare.Notificare;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificareRepository extends MongoRepository<Notificare, Integer> {

    @Query(value= "{dbName : ?0}")
    List<Notificare> findAllByDbName(String dbName);

}
