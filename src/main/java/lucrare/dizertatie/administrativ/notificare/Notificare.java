package lucrare.dizertatie.administrativ.notificare;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Document("notificare")
public class Notificare implements Serializable {

    @Id
    private ObjectId id;

    private String dataOra;

    private String dbName;

    private String obiect;

    private String mesaj;

}
