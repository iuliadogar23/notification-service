package lucrare.dizertatie.administrativ.notificare.service;

import lombok.RequiredArgsConstructor;
import lucrare.dizertatie.administrativ.notificare.Notificare;
import lucrare.dizertatie.administrativ.notificare.service.repository.NotificareRepository;
import lucrare.dizertatie.common.exception.RepositoryException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
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
        notificare.setDataOra(String.valueOf(new Timestamp(System.currentTimeMillis())));

        try {
            return notificareRepository.save(notificare);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RepositoryException();
        }
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
