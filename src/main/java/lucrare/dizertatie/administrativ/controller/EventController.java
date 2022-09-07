package lucrare.dizertatie.administrativ.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController("/event")
public class EventController {

    public List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @RequestMapping(value = "/subscribe", consumes = MediaType.ALL_VALUE)
    public SseEmitter subscribe(@RequestParam String fisaNr)
    {
        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
        try {
            sseEmitter.send(SseEmitter.event().name("INIT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        emitters.add(sseEmitter);
        sseEmitter.onCompletion(()->emitters.remove(sseEmitter));
        return sseEmitter;
    }
//
//    @PostMapping("/dispatch-event")
//    public void dispatchEventToClient(@RequestParam String title, @RequestParam)

}
