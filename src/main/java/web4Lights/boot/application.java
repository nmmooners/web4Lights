package web4Lights.boot;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import twitter4j.conf.ConfigurationBuilder;
//import web4Lights.boot.web4Lights.boot.controller.buttonListeners;
import twitter4j.*;
import twitter4j.conf.*;
import twitter4j.conf.ConfigurationBuilder;
//import web4Lights.boot.web4Lights.boot.controller.twitter;

import java.util.Timer;

@SpringBootApplication
public class application extends SpringBootServletInitializer{



    public static void main(String[] args)
    {
        Object[] sources = {application.class};
        SpringApplication.run(sources, args);

        //lightsContoller tempLights = new lightsContoller();


    }

}


