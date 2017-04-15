package web4Lights.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by nmmoo on 3/16/2017.
 *
 * this is the STOMP CONTROLLER FOR SOCKETS
 */

@Configuration
@EnableWebSocketMessageBroker
public class socketSetup extends AbstractWebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry brokerConfig)
    {
        brokerConfig.enableSimpleBroker("/lightsStatus");
        brokerConfig.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry reg)
    {
        reg.addEndpoint("/gs-guide-websocket").withSockJS();
    }











}
