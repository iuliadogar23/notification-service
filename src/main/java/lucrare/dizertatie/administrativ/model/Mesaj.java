package lucrare.dizertatie.administrativ.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Document("mesaj")
public class Mesaj implements Serializable {

    @Id
    private ObjectId id;

    private UUID uid;

    private String dataOra;

    private String sender;

    private String receiver;

    private String mesaj;

    private boolean reply;

}
