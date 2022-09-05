package lucrare.dizertatie.administrativ.controller;

import lucrare.dizertatie.administrativ.model.Mesaj;
import lucrare.dizertatie.administrativ.service.MesajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesaj")
public class MesajAPIController {

    @Autowired
    MesajService mesajService;

    @GetMapping("/uid")
    public ResponseEntity<List<Mesaj>> getAllByUid(@RequestParam String uid)
    {
        return ResponseEntity.ok(mesajService.findByUid(uid));
    }

    @GetMapping("/receiver")
    public ResponseEntity<List<Mesaj>> getAllByReceiverUnresponded(@RequestParam String receiver)
    {
        return ResponseEntity.ok(mesajService.getAllByReceiverUnreplied(receiver));
    }

    @PostMapping("/save")
    public ResponseEntity<Mesaj> saveMesaj(@RequestBody Mesaj mesaj)
    {
        return ResponseEntity.ok(mesajService.save(mesaj));
    }

}
