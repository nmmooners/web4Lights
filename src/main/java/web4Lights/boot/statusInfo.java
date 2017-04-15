package web4Lights.boot;

/**
 * Created by nmmoo on 3/17/2017.
 */
public class statusInfo {

    private String pinNum;
    private String pinState;
    public statusInfo()
    {

    }

    public statusInfo(String pNum, String pState)
    {
        this.pinNum = pNum;
        this.pinState = pState;
    }

    public String getNum()
    {
        return pinNum;
    }

    public String getState()
    {
        return pinState;
    }
}
