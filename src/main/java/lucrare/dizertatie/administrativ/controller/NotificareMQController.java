package lucrare.dizertatie.administrativ.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lucrare.dizertatie.administrativ.model.NewsScor;
import lucrare.dizertatie.administrativ.model.Notificare;
import lucrare.dizertatie.administrativ.service.NotificareService;
import lucrare.dizertatie.common.exception.MessagingException;
import lucrare.dizertatie.common.exception.RepositoryException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class NotificareMQController implements MessageListener {

    @Autowired
    private NotificareService notificareService;
    @Autowired
    private SimpMessagingTemplate webSocket;

    public void onMessage(Message message) {

        Notificare notificare;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            notificare = objectMapper.readValue(message.getBody(), Notificare.class);
            if (notificare != null && notificare.getDbName() != null && !notificare.getDbName().equals("simulator"))
                notificareService.save(notificare);
            else if (notificare.getDbName().equals("simulator")){
                NewsScor newsScor = getObjectFromString(notificare.getObiect());
//                webSocket.convertAndSend(new Gson().toJson(newsScor));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new MessagingException();
        } catch (RepositoryException e) {
            throw e;
        }

    }

    private NewsScor getObjectFromString(String message)
    {
        NewsScor newsScor = new NewsScor();
        String[] lines = message.split(System.getProperty("line.separator"));
        for (String line: lines)
        {
            String[] item = line.split(" : ");
            switch (item[0]){
                case "respiratoryRate":
                    newsScor.setRespiratoryRate(item[1]);
                    break;
                case "oxygenAssistance":
                    newsScor.setOxygenAssistance(item[1]);
                    break;
                case "oxygenSaturation":
                    newsScor.setOxygenSaturation(item[1]);
                    break;
                case "pulse":
                    newsScor.setPulse(item[1]);
                    break;
                case "systolicBloodPressure":
                    newsScor.setSystolicBloodPressure(item[1]);
                    break;
                case "temperature":
                    newsScor.setTemperature(item[1]);
                    break;
                case "newsScore":
                    newsScor.setTotal(item[1]);
                    break;
                case "pacientId":
                    newsScor.setPacientId(item[1]);
                    break;
                default:
                    break;
            }
        }
        return newsScor;

    }

}
