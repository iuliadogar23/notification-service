package lucrare.dizertatie.administrativ.notificare.service;

import lucrare.dizertatie.administrativ.notificare.Notificare;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface NotificareService {

    List<Notificare> getAll();

    List<Notificare> getAllByDbName(String dbName);

    Notificare save(Notificare notificare);

//    void receiveEvents() throws URISyntaxException, IOException, InterruptedException;

}
