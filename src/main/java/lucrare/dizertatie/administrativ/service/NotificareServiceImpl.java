package lucrare.dizertatie.administrativ.service;

import lombok.RequiredArgsConstructor;
import lucrare.dizertatie.administrativ.model.Notificare;
import lucrare.dizertatie.administrativ.repository.NotificareRepository;
import lucrare.dizertatie.common.exception.RepositoryException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificareServiceImpl implements NotificareService {

    private final NotificareRepository notificareRepository;

    @Override
    public List<Notificare> getAll() {
        return notificareRepository.findAll();
    }

    @Override
    public List<Notificare> getAllByDbName(String dbName) {
        return notificareRepository.findAllByDbName(dbName);
    }

    @Override
    public Notificare save(Notificare notificare)
    {

        List<Notificare> notificareList = notificareRepository.findAllByMesaj(notificare.getMesaj());
        if (notificareList.isEmpty())
            return notificareRepository.save(notificare);
        Collections.reverse(notificareList);
        if (System.currentTimeMillis()-Timestamp.valueOf(notificareList.get(0).getDataOra()).getTime()>2000){
            notificare.setDataOra(String.valueOf(new Timestamp(System.currentTimeMillis())));

            try {
                return notificareRepository.save(notificare);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RepositoryException();
            }
        }
        return null;
    }
//
//    public void receiveEvents() throws URISyntaxException, IOException, InterruptedException {
//        URI uri = new URI("");
//        var client = HttpClient.newHttpClient();
//        var request = HttpRequest.newBuilder(uri).GET().build();
//        var lines = client.send(request, HttpResponse.BodyHandlers.ofLines()).body();
//        lines.forEach(System.out::println);
//    }
}
