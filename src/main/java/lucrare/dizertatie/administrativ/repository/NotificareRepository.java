package lucrare.dizertatie.administrativ.repository;

import lucrare.dizertatie.administrativ.model.Notificare;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificareRepository extends MongoRepository<Notificare, ObjectId> {

    @Query(value = "{$or: [{dbName : ?0 },{dbName : 'management_intern'}]}")
    List<Notificare> findAllByDbName(String dbName);

//    @Aggregation(pipeline = {
//            "{$sort: {$natural : -1}}",
//            "{$limit: 1}"
//    })

    List<Notificare> findAllByMesaj(String mesaj);

}
