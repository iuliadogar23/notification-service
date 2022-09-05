package lucrare.dizertatie.administrativ.repository;

import lucrare.dizertatie.administrativ.model.Mesaj;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MesajRepository extends MongoRepository<Mesaj, ObjectId> {

    List<Mesaj> findAllByReceiverAndReplyIsFalse(String receiver);

    List<Mesaj> findAllByUid(UUID uuid);


}
