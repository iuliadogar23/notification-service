package lucrare.dizertatie.administrativ.service;

import lucrare.dizertatie.administrativ.model.Mesaj;

import java.util.List;

public interface MesajService {

    Mesaj save(Mesaj mesaj);

    List<Mesaj> getAll();

    List<Mesaj> findByUid(String uid);

    List<Mesaj> getAllByReceiverUnreplied(String receiver);


}
