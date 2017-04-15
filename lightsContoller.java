package web4Lights.boot.web4Lights.boot.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pi4j.io.gpio.*;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class lightsContoller {
/*
    private static GpioPinDigitalOutput pin02;
    private static GpioPinDigitalOutput pin03;
    private static GpioPinDigitalOutput pin07;
    private static GpioPinDigitalOutput pin08;
    private static GpioPinDigitalOutput pin09;
    private static GpioPinDigitalOutput pin12;
    private static GpioPinDigitalOutput pin13;
    private static GpioPinDigitalOutput pin22;
*/

    private static GpioPinDigitalOutput pin02;
    private static GpioPinDigitalOutput pin03;
    private static GpioPinDigitalOutput pin04;

    private static GpioPinDigitalOutput pin09;
    private static GpioPinDigitalOutput pin10;
    private static GpioPinDigitalOutput pin11;

    private static GpioPinDigitalOutput pin17;

    private static GpioPinDigitalOutput pin22;




/*
    @RequestMapping("/")
    public void home()
    {
        System.out.println("home accessed");

    }

*/


    @RequestMapping(value = "/light13", method = RequestMethod.POST)
    public
    @ResponseBody
    String lightSwitch(@RequestBody String lightPick, HttpServletRequest request) {

        Gson gson = new Gson();
        JSONObject lights = gson.fromJson(lightPick, JSONObject.class);
        String whichLight = lights.get("lightNum").toString();

        System.out.println(whichLight);
        int intLight = Integer.valueOf(whichLight);
        String retString = whichLight + " selected";
        System.out.println(retString);
        switch (intLight)
        {
            case 2:
                //pin02.toggle();
                System.out.println("pin 2 for relay 8");
                break;
            case 3:
                //pin03.toggle();
                System.out.println("pin 3 for relay 7");
                break;
            case 4:
                //pin04.toggle();
                System.out.println("pin 4 for relay 6");
                break;
            case 9:
                //pin09.toggle();
                System.out.println("pin 9 for relay 5");
                break;
            case 10:
                //pin10.toggle();
                System.out.println("pin 10 for relay 2");
                break;
            case 11:
                //pin11.toggle();
                System.out.println("pin 11 for relay 1");
                break;
            case 17:
                //pin17.toggle();
                System.out.println("pin 17 for relay 4");
                break;
            case 22:
                //pin02.toggle();
                System.out.println("pin 22 for relay 3");
                break;
            default:
                System.out.println("didnt hit it");
        }

        return retString;
    }


}




/*
    @RequestMapping("/light02")
    public String light02()
    {
        if(pin02 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "number02", PinState.LOW);
        }

        pin02.toggle();
        String lightNum = "toggled 02";
        System.out.println(lightNum);
        return lightNum;
    }

    @RequestMapping("/light03")
    public String light03()
    {
        if(pin03 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "number03", PinState.LOW);
        }

        pin03.toggle();
        String lightNum = "toggled 03";
        System.out.println(lightNum);
        return lightNum;
    }
/*
    @RequestMapping("/light07")
    public String light07()
    {
        if(pin07 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "number07", PinState.LOW);
        }

        pin07.toggle();
        String lightNum = "toggled 07";
        System.out.println(lightNum);
        return lightNum;
    }

    @RequestMapping("/light08")
    public String light08()
    {
        if(pin08 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "number08", PinState.LOW);
        }

        pin08.toggle();
        String lightNum = "toggled 08";
        System.out.println(lightNum);
        return lightNum;
    }
*/
/*
    @RequestMapping("/light09")
    public String light09()
    {
        if(pin09 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "number09", PinState.LOW);
        }

        pin09.toggle();
        String lightNum = "toggled 09";
        System.out.println(lightNum);
        return lightNum;
    }
/*
    @RequestMapping("/light12")
    public String light12()
    {
        if(pin12 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "number12", PinState.LOW);
        }

        pin12.toggle();
        String lightNum = "toggled 12";
        System.out.println(lightNum);
        return lightNum;
    }

    @RequestMapping("/light13")
    public String light13()
    {
        if(pin13 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "number13", PinState.LOW);
        }

        pin13.toggle();
        String lightNum = "toggled 13";
        System.out.println(lightNum);
        return lightNum;
    }
*/
/*
    @RequestMapping("/light22")
    public String light22()
    {
        if(pin22 == null)
        {
            GpioController gpio = GpioFactory.getInstance();
            pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "number22", PinState.LOW);
        }

        pin22.toggle();
        String lightNum = "toggled 22";
        System.out.println(lightNum);
        return lightNum;
    }

}
*/
