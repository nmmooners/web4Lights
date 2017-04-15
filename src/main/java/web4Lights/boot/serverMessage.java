package web4Lights.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by nmmoo on 3/18/2017.
 */
public class serverMessage {

    @Autowired
    private SimpMessagingTemplate template;


    @RequestMapping(value = "/lightsSocket", method = POST)
    public void sendMes(String pNum, String pState)
    {

        this.template.convertAndSend("/lightsStatus/statusInfo", new statusInfo(pNum, pState));
    }






}
