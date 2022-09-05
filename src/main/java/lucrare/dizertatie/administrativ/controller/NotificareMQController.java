package lucrare.dizertatie.administrativ.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lucrare.dizertatie.administrativ.model.Notificare;
import lucrare.dizertatie.administrativ.service.NotificareService;
import lucrare.dizertatie.common.exception.MessagingException;
import lucrare.dizertatie.common.exception.RepositoryException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class NotificareMQController implements MessageListener {

    @Autowired
    private NotificareService notificareService;

    public void onMessage(Message message) {

        Notificare notificare;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            notificare = objectMapper.readValue(message.getBody(), Notificare.class);
            if (notificare != null)
                notificareService.save(notificare);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MessagingException();
        } catch (RepositoryException e) {
            throw e;
        }

    }

}
