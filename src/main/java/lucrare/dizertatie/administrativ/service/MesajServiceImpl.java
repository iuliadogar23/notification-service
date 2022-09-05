package lucrare.dizertatie.administrativ.service;

import lucrare.dizertatie.administrativ.model.Mesaj;
import lucrare.dizertatie.administrativ.repository.MesajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MesajServiceImpl implements MesajService{

    @Autowired
    private MesajRepository mesajRepository;

    @Override
    public Mesaj save(Mesaj mesaj) {
        if (mesaj.getUid()==null)
            mesaj.setUid(UUID.randomUUID());
        if (mesaj.isReply())
        {
            Mesaj request = mesajRepository.findAllByUid(mesaj.getUid()).get(0);
            request.setReply(true);
            mesajRepository.save(request);
        }

        return mesajRepository.save(mesaj);
    }

    @Override
    public List<Mesaj> getAll() {
        return mesajRepository.findAll();
    }

    @Override
    public List<Mesaj> findByUid(String uid) {
        return mesajRepository.findAllByUid(UUID.fromString(uid));
    }

    @Override
    public List<Mesaj> getAllByReceiverUnreplied(String receiver) {
        return mesajRepository.findAllByReceiverAndReplyIsFalse(receiver);
    }
}
