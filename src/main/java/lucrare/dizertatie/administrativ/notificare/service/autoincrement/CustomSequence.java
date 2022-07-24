package lucrare.dizertatie.administrativ.notificare.service.autoincrement;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customSequences")
public class CustomSequence {

    @Id
    private String id;

    private int seq;

}
