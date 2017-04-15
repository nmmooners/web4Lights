package web4Lights.boot;

import com.google.gson.Gson;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;



@RestController
@Controller
public class lightsContoller {



    private twitter trySomeTweets = new twitter();



//    static GpioController gpio = GpioFactory.getInstance();
//    private GpioPinDigitalInput pin03In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);
//    private GpioPinDigitalInput pin07In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);
//    private GpioPinDigitalInput pin08In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_08, PinPullResistance.PULL_DOWN);
//    private GpioPinDigitalInput pin09In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_09, PinPullResistance.PULL_DOWN);
//    private GpioPinDigitalInput pin12In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_12, PinPullResistance.PULL_DOWN);
//    private GpioPinDigitalInput pin13In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_13, PinPullResistance.PULL_DOWN);
////    private GpioPinDigitalInput pin14In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_14, PinPullResistance.PULL_DOWN);
//    private GpioPinDigitalInput pin22In = gpio.provisionDigitalInputPin(RaspiPin.GPIO_22, PinPullResistance.PULL_DOWN);
//    //private gpioPins tryingPins = new gpioPins();



///*    private GpioPinDigitalOutput pin03;
//    private GpioPinDigitalOutput pin07;
//    private GpioPinDigitalOutput pin08;
//    private GpioPinDigitalOutput pin09;
//    private GpioPinDigitalOutput pin12;
//    private GpioPinDigitalOutput pin13;
//*/    private static GpioPinDigitalOutput pin14;
////    private GpioPinDigitalOutput pin22;




//    public lightsContoller()
//    {
//
//
//
//        pin03In.setShutdownOptions(true);
//        pin07In.setShutdownOptions(true);
//        pin08In.setShutdownOptions(true);
//        pin09In.setShutdownOptions(true);
//        pin12In.setShutdownOptions(true);
//        pin13In.setShutdownOptions(true);
////        pin14In.setShutdownOptions(true);
//        pin22In.setShutdownOptions(true);
//
//
//
//
//        pin03In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin 3 was listened to for relay 3 is HIGH");
//                    sendMes("pin3", "HIGH");
//                    //sendMes("pin 3 was listened to for relay 3 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin 3 was listened to for relay 3 is LOW");
//                    sendMes("pin3", "LOW");
//                    //sendMes("pin 3 was listened to for relay 3 is LOW");
//                }
//            }
//        });
//
//        pin07In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin 07 was listened to for relay 6 is HIGH");
//                    sendMes("pin7", "HIGH");
//                    //sendMes("pin 7 was listened to for relay 6 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin 07 was listened to for relay 6 is LOW");
//                    sendMes("pin7", "LOW");
//                    //sendMes("pin 7 was listened to for relay 6 is LOW");
//                }
//            }
//        });
//
//        pin08In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin08 was listened to for relay 8 is HIGH");
//                    sendMes("pin8", "HIGH");
//                    //sendMes("pin08 was listened to for relay 8 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin08 was listened to for relay 8 is LOW");
//                    sendMes("pin8", "LOW");
//                    //sendMes("pin08 was listened to for relay 8 is LOW");
//                }
//            }
//        });
//
//        pin09In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin09 was listened to for relay 7 is HIGH");
//                    sendMes("pin9", "HIGH");
//                    //sendMes("pin09 was listened to for relay 7 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin09 was listened to for relay 7 is LOW");
//                    sendMes("pin9", "LOW");
//                    //sendMes("pin09 was listened to for relay 7 is LOW");
//                }
//            }
//        });
//
//        pin12In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin12 was listened to for relay 2 is HIGH");
//                    sendMes("pin12", "HIGH");
//                    //sendMes("pin12 was listened to for relay 2 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin12 was listened to for relay 2 is LOW");
//                    sendMes("pin12", "LOW");
//                    //sendMes("pin12 was listened to for relay 2 is LOW");
//                }
//            }
//        });
//
//        pin13In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin13 was listened to for relay 5 is HIGH");
//                    sendMes("pin13", "HIGH");
//                    //sendMes("pin13 was listened to for relay 5 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin13 was listened to for relay 5 is LOW");
//                    sendMes("pin13", "LOW");
//                    //sendMes("pin13 was listened to for relay 5 is LOW");
//                }
//            }
//        });
///*
//        pin14In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin14 was listened to for relay 1 is HIGH");
//                    sendMes("pin14", "HIGH");
//                    //sendMes("pin14 was listened to for relay 1 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin14 was listened to for relay 1 is LOW");
//                    sendMes("pin14", "LOW");
//                    //sendMes("pin14 was listened to for relay 1 is LOW");
//                }
//            }
//        });
//*/
//        pin22In.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                if(event.getState().isHigh())
//                {
//                    System.out.println("pin22 was listened to for relay 4 is HIGH");
//                    sendMes("pin22", "HIGH");
//                    //sendMes("pin22 was listened to for relay 4 is HIGH");
//                }
//                else
//                {
//                    System.out.println("pin22 was listened to for relay 4 is LOW");
//                    sendMes("pin22", "LOW");
//                    //sendMes("pin22 was listened to for relay 4 is LOW");
//                }
//            }
//        });
//    }






    @RequestMapping(value = "/light13", method = RequestMethod.POST)
    public
    @ResponseBody
    String lightSwitch(@RequestBody String lightPick, HttpServletRequest request) {

        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(lightPick, JSONObject.class);
        String whichLight = lights.get("lightNum").toString();
        String pinState = "dont know";

        retObj toBeSentBack = new retObj();




        System.out.println(whichLight);
        int intLight = Integer.valueOf(whichLight);
        System.out.println(intLight);
        String retString = whichLight + " selected";

        System.out.println(retString);
        switch (intLight)
        {
            /*
            case 2:
                if(pin02 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Gpio02", PinState.LOW);
                }
                pin02.toggle();
                System.out.println("pin 2 for relay ?");
                break;
            */
            case 3:
/*               if(pin03 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Gpio03", PinState.LOW);
                }
                pin03.toggle();
                pinState = pin03.getState().toString();
*/                System.out.println("pin 3 for relay 3 has a state of: " + pinState);
                break;
            /*
            case 4:
                if(pin04 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Gpio04", PinState.LOW);
                }
                pin04.toggle();
                System.out.println("pin 4 for relay ?");
                break;
            case 5:
                if(pin05 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Gpio05", PinState.LOW);
                }
                pin05.toggle();
                System.out.println("pin 5 for relay ?");
                break;
            case 6:
                if(pin06 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Gpio06", PinState.LOW);
                }
                pin06.toggle();
                System.out.println("pin 6 for relay ?");
                break;
            */
            case 7:
/*                if(pin07 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Gpio07", PinState.LOW);
                }
                pin07.toggle();
               pinState = pin07.getState().toString();
*/              System.out.println("pin 7 for relay 6 has a state of: " + pinState);
                break;
            case 8:
/*                if(pin08 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Gpio08", PinState.LOW);
                }
                pin08.toggle();
                pinState = pin08.getState().toString();
*/                System.out.println("pin 8 for relay 8 has a state of: " + pinState);
                break;
            case 9:
/*                if(pin09 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Gpio09", PinState.LOW);
                }
                pin09.toggle();
                pinState = pin09.getState().toString();
*/                System.out.println("pin 9 for relay 7 has a state of: " + pinState);
                break;
            /*
            case 10:
                if(pin10 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "Gpio10", PinState.LOW);
                }
                pin10.toggle();
                System.out.println("pin 10 for relay ?");
                break;
            case 11:
                if(pin11 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "Gpio11", PinState.LOW);
                }
                pin11.toggle();
                System.out.println("pin 11 for relay ?");
                break;
            */
            case 12:
/*                if(pin12 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Gpio12", PinState.LOW);
                }
                pin12.toggle();
                pinState = pin12.getState().toString();
*/                System.out.println("pin 12 for relay 2 has a state of: " + pinState);
                break;
            case 13:
/*                if(pin13 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Gpio13", PinState.LOW);
                }
                pin13.toggle();
                pinState = pin13.getState().toString();
*/                System.out.println("pin 13 for relay 5 has a state of: " + pinState);
                break;
            case 14:
//                if(pin14 == null)
//                {
//                    GpioController gpioOUT = GpioFactory.getInstance();
//                    pin14 = gpioOUT.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Gpio14", PinState.LOW);
//                }
///*                if(pin14.getState() == PinState.HIGH)
//                {
//                    pin14.setState(PinState.LOW);
//                }
//                else
//                {
//                    pin14.setState(PinState.HIGH);
//                }
//*/              pin14.toggle();
//                pinState = pin14.getState().toString();
                System.out.println("pin 14 for relay 1 has a state of: " + pinState);
                break;
            /*
            case 15:
                if(pin15 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Gpio15", PinState.LOW);
                }
                pin15.toggle();
                System.out.println("pin 15 for relay ?");
                break;
            case 16:
                if(pin16 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "Gpio16", PinState.LOW);
                }
                pin16.toggle();
                System.out.println("pin 16 for relay ?");
                break;
            case 17:
                if(pin17 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "Gpio17", PinState.LOW);
                }
                pin17.toggle();
                System.out.println("pin 17 for relay ?");
                break;
            case 18:
                if(pin18 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "Gpio18", PinState.LOW);
                }
                pin18.toggle();
                System.out.println("pin 18 for relay ?");
                break;
            case 19:
                if(pin19 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin19 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, "Gpio19", PinState.LOW);
                }
                pin19.toggle();
                System.out.println("pin 19 for relay ?");
                break;
            case 20:
                if(pin20 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin20 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, "Gpio20", PinState.LOW);
                }
                pin20.toggle();
                System.out.println("pin 20 for relay ?");
                break;
            case 21:
                if(pin21 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin21 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "Gpio21", PinState.LOW);
                }
                pin21.toggle();
                System.out.println("pin 21 for relay ?");
                break;
            */
            case 22:
/*                if(pin22 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Gpio22", PinState.LOW);
                }
                pin22.toggle();
                pinState = pin22.getState().toString();
*/                System.out.println("pin 22 for relay 4 has a state of: " + pinState);
                break;
            /*
            case 23:
                if(pin23 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin23 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "Gpio23", PinState.LOW);
                }
                pin23.toggle();
                System.out.println("pin 23 for relay ?");
                break;
            case 24:
                if(pin24 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin24 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "Gpio24", PinState.LOW);
                }
                pin24.toggle();
                System.out.println("pin 23 for relay ?");
                break;
            case 25:
                if(pin25 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin25 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "Gpio25", PinState.LOW);
                }
                pin25.toggle();
                System.out.println("pin 25 for relay ?");
                break;
            case 26:
                if(pin26 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "Gpio26", PinState.LOW);
                }
                pin23.toggle();
                System.out.println("pin 23 for relay ?");
                break;
            */
            default:
                System.out.println("didnt hit it");
        }

        if(pinState == "HIGH")
        {
            pinState = "ON";
        }
        else
        {
            pinState = "OFF";
        }
        toBeSentBack.retStringObj = retString;
        toBeSentBack.pinStateObj = pinState;

        retString = gson.toJson(toBeSentBack);

        System.out.println(retString);
        System.out.println("sending back");


        return retString;
    }


    @RequestMapping(value = "/offAll", method = RequestMethod.POST)
    public
    @ResponseBody
    String turnAllOff(@RequestBody String clearInfo, HttpServletRequest request)
    {
        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(clearInfo, JSONObject.class);
        String clearString = lights.get("allOff").toString();

        System.out.println("Turning All Off");
/*
        pin03.high();
        pin07.high();
        pin08.high();
        pin09.high();
        pin12.high();
        pin13.high();
        pin14.high();
        pin22.high();
*/
        System.out.println("All now off");

        String retClear = "All Off";
        return retClear;
    }


    @RequestMapping(value = "/onAll", method = RequestMethod.POST)
    public
    @ResponseBody
    String turnAllOn(@RequestBody String turnOn, HttpServletRequest request)
    {
        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(turnOn, JSONObject.class);
        String clearString = lights.get("allOn").toString();

        System.out.println("Turning All on");
/*
        pin03.low();
        pin07.low();
        pin08.low();
        pin09.low();
        pin12.low();
        pin13.low();
        pin14.low();
        pin22.low();
*/
        System.out.println("All now on");

        String retClear = "All ON";
        return retClear;
    }




    @RequestMapping(value = "/clearIt", method = RequestMethod.POST)
    public
    @ResponseBody
    String clearInfo(@RequestBody String clearInfo, HttpServletRequest request)
    {
        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(clearInfo, JSONObject.class);
        String clearString = lights.get("clearMe").toString();

        System.out.println("clearString");
        String retClear = "\n";
        return retClear;


    }



    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public
    @ResponseBody
    String statusInfo(@RequestBody String stats, HttpServletRequest request)
    {
        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(stats, JSONObject.class);
        String whichLight = lights.get("lightNum").toString();
        String pinState = "dont know";

        retObj toBeSentBack = new retObj();




        System.out.println(whichLight);
        int intLight = Integer.valueOf(whichLight);
        System.out.println(intLight);
        String retString = whichLight + " selected";


        System.out.println(retString);
        switch (intLight)
        {
            /*
            case 2:
                if(pin02 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Gpio02", PinState.LOW);
                }
                pin02.toggle();
                System.out.println("pin 2 for relay ?");
                break;
            */
            case 3:
/*                if(pin03 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Gpio03", PinState.LOW);
                }
                pinState = pin03.getState().toString();
 */               System.out.println("pin 3 for relay 3 has a state of: " + pinState);
                break;
            /*
            case 4:
                if(pin04 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Gpio04", PinState.LOW);
                }
                pin04.toggle();
                System.out.println("pin 4 for relay ?");
                break;
            case 5:
                if(pin05 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Gpio05", PinState.LOW);
                }
                pin05.toggle();
                System.out.println("pin 5 for relay ?");
                break;
            case 6:
                if(pin06 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Gpio06", PinState.LOW);
                }
                pin06.toggle();
                System.out.println("pin 6 for relay ?");
                break;
            */
            case 7:
/*                if(pin07 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Gpio07", PinState.LOW);
                }
                pinState = pin07.getState().toString();
*/                System.out.println("pin 7 for relay 6 has a state of: " + pinState);
                break;
            case 8:
/*                if(pin08 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Gpio08", PinState.LOW);
                }
                pinState = pin08.getState().toString();
*/                System.out.println("pin 8 for relay 8 has a state of: " + pinState);
                break;
            case 9:
/*                if(pin09 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Gpio09", PinState.LOW);
                }
                pinState = pin09.getState().toString();
*/                System.out.println("pin 9 for relay 7 has a state of: " + pinState);
                break;
            /*
            case 10:
                if(pin10 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "Gpio10", PinState.LOW);
                }
                pin10.toggle();
                System.out.println("pin 10 for relay ?");
                break;
            case 11:
                if(pin11 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "Gpio11", PinState.LOW);
                }
                pin11.toggle();
                System.out.println("pin 11 for relay ?");
                break;
            */
            case 12:
/*                if(pin12 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Gpio12", PinState.LOW);
                }
                pinState = pin12.getState().toString();
*/               System.out.println("pin 12 for relay 2 has a state of: " + pinState);
                break;
            case 13:
/*                if(pin13 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Gpio13", PinState.LOW);
                }
                pinState = pin13.getState().toString();
*/                System.out.println("pin 13 for relay 5 has a state of: " + pinState);
                break;
            case 14:
//                if(pin14 == null)
//                {
//                    GpioController gpio = GpioFactory.getInstance();
//                    pin14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Gpio14", PinState.LOW);
//                }
//                pinState = pin14.getState().toString();
                System.out.println("pin 14 for relay 1 has a state of: " + pinState);
                break;
            /*
            case 15:
                if(pin15 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Gpio15", PinState.LOW);
                }
                pin15.toggle();
                System.out.println("pin 15 for relay ?");
                break;
            case 16:
                if(pin16 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "Gpio16", PinState.LOW);
                }
                pin16.toggle();
                System.out.println("pin 16 for relay ?");
                break;
            case 17:
                if(pin17 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "Gpio17", PinState.LOW);
                }
                pin17.toggle();
                System.out.println("pin 17 for relay ?");
                break;
            case 18:
                if(pin18 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "Gpio18", PinState.LOW);
                }
                pin18.toggle();
                System.out.println("pin 18 for relay ?");
                break;
            case 19:
                if(pin19 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin19 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, "Gpio19", PinState.LOW);
                }
                pin19.toggle();
                System.out.println("pin 19 for relay ?");
                break;
            case 20:
                if(pin20 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin20 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, "Gpio20", PinState.LOW);
                }
                pin20.toggle();
                System.out.println("pin 20 for relay ?");
                break;
            case 21:
                if(pin21 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin21 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "Gpio21", PinState.LOW);
                }
                pin21.toggle();
                System.out.println("pin 21 for relay ?");
                break;
            */
            case 22:
/*                if(pin22 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Gpio22", PinState.LOW);
                }
                pinState = pin22.getState().toString();
*/                System.out.println("pin 22 for relay 4 has a state of: " + pinState);
                break;
            /*
            case 23:
                if(pin23 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin23 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "Gpio23", PinState.LOW);
                }
                pin23.toggle();
                System.out.println("pin 23 for relay ?");
                break;
            case 24:
                if(pin24 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin24 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "Gpio24", PinState.LOW);
                }
                pin24.toggle();
                System.out.println("pin 23 for relay ?");
                break;
            case 25:
                if(pin25 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin25 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "Gpio25", PinState.LOW);
                }
                pin25.toggle();
                System.out.println("pin 25 for relay ?");
                break;
            case 26:
                if(pin26 == null)
                {
                    GpioController gpio = GpioFactory.getInstance();
                    pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "Gpio26", PinState.LOW);
                }
                pin23.toggle();
                System.out.println("pin 23 for relay ?");
                break;
            */
            default:
                System.out.println("didnt hit it");
        }

        if(pinState == "HIGH")
        {
            pinState = "OFF";
        }
        else
        {
            pinState = "ON";
        }
        toBeSentBack.retStringObj = retString;
        toBeSentBack.pinStateObj = pinState;

        retString = gson.toJson(toBeSentBack);

        System.out.println(retString);


        return retString;

    }


    @RequestMapping(value = "/socialDisplay", method = RequestMethod.POST)
    public
    @ResponseBody
    String socialUpdates(@RequestBody String stats, HttpServletRequest request)
    {
        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(stats, JSONObject.class);
        String whichLight = lights.get("social").toString();

        System.out.println("socialString");


        //instagram socialIG = trySomeIG.printJSON();


        String retString =  trySomeTweets.getSingleHtml();


        //trying to send message on sockets path from server

        //sendMes("From Server");

        //String retString = "social";
        return retString;

    }



    @RequestMapping(value = "/adminTweetList", method = RequestMethod.POST)
    public
    @ResponseBody
    String adminTweetsList(@RequestBody String stats, HttpServletRequest request)
    {
        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(stats, JSONObject.class);
        String whichLight = lights.get("social").toString();
        int whichTweetToGet = Integer.parseInt(whichLight);

        /*
        String[] tempArray = new String[trySomeTweets.getList().size()];
        JSONObject returnJSONTweets = new JSONObject();

        String tweetNum = "0";
        String tweetHTML = trySomeTweets.getSpecificHtml(0);
        tempArray[0] = tweetHTML;
        adminAllObj tempAll = new adminAllObj();
        tempAll.tweetArray = tempArray;

        System.out.println(tweetHTML);

        System.out.println("socialString");

        String retString = gson.toJson(tempAll, JSONObject.class);
*/
        //String retString =  trySomeTweets.getSingleHtml();

       // adminAllObj returning = new adminAllObj();
        web4Lights.boot.adminAllObj returning = new web4Lights.boot.adminAllObj();
        returning.howManyTweets = Integer.toString(trySomeTweets.getList().size());
        returning.returnTweetHTML = trySomeTweets.getSpecificHtml(whichTweetToGet);
        returning.thisTweetCount = whichLight;





        String retString = gson.toJson(returning);

        //String retString = "social";


        return retString;

    }



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
        System.out.println("pNumber: " + info.getNum() + " pState: " + info.getState());
        return new statusInfo(info.getNum(), info.getState());

    }


    public void sendMes(String pNum, String pState)
    {
        System.out.println("message attempted");
        this.template.convertAndSend("/lightsStatus/statusInfo", new statusInfo(pNum, pState));
    }




}




