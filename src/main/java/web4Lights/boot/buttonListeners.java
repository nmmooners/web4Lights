package web4Lights.boot;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;


public class buttonListeners
{

    public static void inputControll() throws InterruptedException
    {



        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalInput pin02 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
        //        final GpioPinDigitalOutput pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Gpio03", PinState.LOW);


        final GpioPinDigitalInput pin04 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_04, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin05 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput pin06 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN);

        //        private static GpioPinDigitalOutput pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Gpio07", PinState.LOW);
        //        private static GpioPinDigitalOutput pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Gpio08", PinState.LOW);

        //        private static GpioPinDigitalOutput pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Gpio09", PinState.LOW);
        final GpioPinDigitalInput pin10 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_10, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput pin11 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_11, PinPullResistance.PULL_DOWN);

        //        private static GpioPinDigitalOutput pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Gpio12", PinState.LOW);

        //        private static GpioPinDigitalOutput pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Gpio13", PinState.LOW);

        //        private static GpioPinDigitalOutput pin14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Gpio14", PinState.LOW);
        final GpioPinDigitalInput pin15 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin16 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin17 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_17, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin18 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_18, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin19 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_19, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin20 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_20, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput pin21 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_21, PinPullResistance.PULL_DOWN);

        //        private static GpioPinDigitalOutput pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Gpio22", PinState.LOW);

        final GpioPinDigitalInput pin23 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_23, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput pin24 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_24, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin25 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN);

        final GpioPinDigitalInput pin26 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_26, PinPullResistance.PULL_DOWN);


        pin02.setShutdownOptions(true);
        pin04.setShutdownOptions(true);
        pin05.setShutdownOptions(true);
        pin06.setShutdownOptions(true);
        pin10.setShutdownOptions(true);
        pin11.setShutdownOptions(true);
        pin15.setShutdownOptions(true);
        pin16.setShutdownOptions(true);
        pin17.setShutdownOptions(true);
        pin18.setShutdownOptions(true);
        pin19.setShutdownOptions(true);
        pin20.setShutdownOptions(true);
        pin21.setShutdownOptions(true);
        pin23.setShutdownOptions(true);
        pin24.setShutdownOptions(true);
        pin25.setShutdownOptions(true);
        pin26.setShutdownOptions(true);


        System.out.println("input is ready");
        pin02.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin2's state was hit and is now: " + event.getState());
            }
        });
        pin04.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin4's state was hit and is now: " + event.getState());
            }
        });
        pin05.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin5's state was hit and is now: " + event.getState());
            }
        });
        pin06.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin6's state was hit and is now: " + event.getState());
            }
        });
        pin10.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin10's state was hit and is now: " + event.getState());
            }
        });
        pin11.addListener(new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin11's state was hit and is now: " + event.getState());
            }
        });
        pin15.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin15's state was hit and is now: " + event.getState());
            }
        });
        pin16.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin16's state was hit and is now: " + event.getState());
            }
        });
        pin17.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin17's state was hit and is now: " + event.getState());
            }
        });
        pin18.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin18's state was hit and is now: " + event.getState());
            }
        });
        pin19.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin19's state was hit and is now: " + event.getState());
            }
        });
        pin20.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin20's state was hit and is now: " + event.getState());
            }
        });
        pin21.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin21's state was hit and is now: " + event.getState());
            }
        });
        pin23.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin23's state was hit and is now: " + event.getState());
            }
        });
        pin24.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin24's state was hit and is now: " + event.getState());
            }
        });
        pin25.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin25's state was hit and is now: " + event.getState());
            }
        });
        pin26.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("pin26's state was hit and is now: " + event.getState());
            }
        });


        while(true)
        {
            Thread.sleep(500);
        }


    }
}
