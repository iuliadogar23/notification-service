package lucrare.dizertatie.administrativ.controller;

import lucrare.dizertatie.administrativ.model.Notificare;
import lucrare.dizertatie.administrativ.service.NotificareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificare")
public class NotificareAPIController {

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Autowired
    private NotificareService notificareService;

    @PostMapping("/save")
    public ResponseEntity<Notificare> saveNotificare(@RequestBody Notificare notificare)
    {
        return ResponseEntity.ok(notificareService.save(notificare));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Notificare>> getNotificareDoctor()
    {
        return ResponseEntity.ok(notificareService.getAllByDbName(dbName));
    }



}
