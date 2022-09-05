package lucrare.dizertatie.administrativ.service;

import lucrare.dizertatie.administrativ.model.Notificare;

import java.util.List;

public interface NotificareService {

    List<Notificare> getAll();

    List<Notificare> getAllByDbName(String dbName);

    Notificare save(Notificare notificare);

//    void receiveEvents() throws URISyntaxException, IOException, InterruptedException;

}
