package web4Lights.boot;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * Created by nmmoo on 3/15/2017.
 */

public class gpioPins {

    //static GpioController gpio = GpioFactory.getInstance();

    //private static GpioPinDigitalInput pin02 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,PinPullResistance.PULL_DOWN);
//    private static GpioPinDigitalOutput pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Gpio03", PinState.LOW);
    //reading in from lightshowpi pin3 for relay 3
//    private static GpioPinDigitalInput pin03In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);


    //private static GpioPinDigitalInput pin04 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_04, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin05 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);
    //private static GpioPinDigitalInput pin06 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);


//    private static GpioPinDigitalOutput pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Gpio07", PinState.LOW);
    //reading in from lightshowpi pin7 relay 6
//    private static GpioPinDigitalInput pin07In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);


//    private static GpioPinDigitalOutput pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Gpio08", PinState.LOW);
    //reading in from lightshowpi pin8 relay 8
//    private static GpioPinDigitalInput pin08In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_08, PinPullResistance.PULL_DOWN);


//    private static GpioPinDigitalOutput pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Gpio09", PinState.LOW);
    //reading in from lightshowpi pin9 relay 7
//    private static GpioPinDigitalInput pin09In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_09, PinPullResistance.PULL_DOWN);


    //private static GpioPinDigitalInput pin10 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_10, PinPullResistance.PULL_DOWN);
    //private static GpioPinDigitalInput pin11 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_11, PinPullResistance.PULL_DOWN);


//    private static GpioPinDigitalOutput pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Gpio12", PinState.LOW);
    //reading in from lightshowpi pin12 relay 2
//    private static GpioPinDigitalInput pin12In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_12, PinPullResistance.PULL_DOWN);


//    private static GpioPinDigitalOutput pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Gpio13", PinState.LOW);
    //reading in from lightshowpi pin13 relay 13
//    private static GpioPinDigitalInput pin13In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_13, PinPullResistance.PULL_DOWN);


//   private static GpioPinDigitalOutput pin14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Gpio14", PinState.LOW);
    //reading in from lightshowpi pin14 relay 1
//    private static GpioPinDigitalInput pin14In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_14, PinPullResistance.PULL_DOWN);




    //private static GpioPinDigitalInput pin15 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin16 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin17 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_17, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin18 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_18, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin19 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_19, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin20 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_20, PinPullResistance.PULL_DOWN);
    //private static GpioPinDigitalInput pin21 = g*pio.provisionDigitalInputPin(RaspiPin.GPIO_21, PinPullResistance.PULL_DOWN);

//    private static GpioPinDigitalOutput pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Gpio22", PinState.LOW);
    //reading in from lightshowpi pin22 relay 4
//    private static GpioPinDigitalInput pin22In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_22, PinPullResistance.PULL_DOWN);



    //private static GpioPinDigitalInput pin23 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_23, PinPullResistance.PULL_DOWN);
    //private static GpioPinDigitalInput pin24 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_24, PinPullResistance.PULL_DOWN);

    //private static GpioPinDigitalInput pin25 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN);

    //final GpioPinDigitalInput pin26 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_26, PinPullResistance.PULL_DOWN);

/*
    static GpioController gpio = GpioFactory.getInstance();
    private GpioPinDigitalInput pin03In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin07In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin08In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_08, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin09In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_09, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin12In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_12, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin13In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_13, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin14In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_14, PinPullResistance.PULL_DOWN);
    private GpioPinDigitalInput pin22In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_22, PinPullResistance.PULL_DOWN);
*/

    //private lightsContoller gpioLightLink = new lightsContoller();

/*

    @Autowired
    private SimpMessagingTemplate template = new SimpMessagingTemplate(new MessageChannel() {
        @Override
        public boolean send(Message<?> message) {
            return false;
        }

        @Override
        public boolean send(Message<?> message, long l) {
            return false;
        }
    });



    @MessageMapping("/lightsSocket")
    @SendTo("/lightsStatus/statusInfo")
    public statusInfo letYouKnow(statusInfo info) throws Exception
    {
        System.out.println(info.getStatus());
        return new statusInfo(info.getStatus());

    }


    public void sendMes(String messageFromServer)
    {
        System.out.println("message attempted");
        this.template.convertAndSend("/lightsStatus/statusInfo", new statusInfo(messageFromServer));
    }


/*
    public void setListeners()
    {


        pin03In.setShutdownOptions(true);
        pin07In.setShutdownOptions(true);
        pin08In.setShutdownOptions(true);
        pin09In.setShutdownOptions(true);
        pin12In.setShutdownOptions(true);
        pin13In.setShutdownOptions(true);
        pin14In.setShutdownOptions(true);
        pin22In.setShutdownOptions(true);




        pin03In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
                if(event.getState().isHigh())
                {
                    System.out.println("pin 3 was listened to for relay 3");
                    //gpioLightLink.sendMes("pin 3 was listened to for relay 3");
                    //sendMes("pin 3 was listened to for relay 3");


                }
            }
        });

        pin07In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin 7 was listened to for relay 6");
                    //gpioLightLink.sendMes("pin 7 was listened to for relay 6");
                }
            }
        });

        pin08In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin08 was listened to for relay 8");
                   // gpioLightLink.sendMes("pin08 was listened to for relay 8");
                }
            }
        });

        pin09In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin09 was listened to for relay 7");
                   // gpioLightLink.sendMes("pin09 was listened to for relay 8");
                }
            }
        });

        pin12In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin12 was listened to for relay 2");
                    //gpioLightLink.sendMes("pin08 was listened to for relay 8");
                }
            }
        });

        pin13In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin13 was listened to for relay 5");
                    //gpioLightLink.sendMes("pin08 was listened to for relay 8");
                }
            }
        });

        pin14In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin14 was listened to for relay 1");
                    //gpioLightLink.sendMes("pin08 was listened to for relay 8");
                }
            }
        });

        pin22In.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh())
                {
                    System.out.println("pin22 was listened to for relay 4");
                    //gpioLightLink.sendMes("pin08 was listened to for relay 8");
                }
            }
        });
    }


*/

















}
