package Phonepe;


public class PhoneMain {

    private int PhonePayPin;
    private int AxisPin;
    private int CanaraPin;
    private int HDFCPin;

    private int AxisPinCount = 0;
    private int CanaraPinCount = 0;
    private int HDFCPinCount = 0;


    private static PhoneMain Payobject = null;

    public void setPhonePayPin(int PhonePayPin){
        this.PhonePayPin=PhonePayPin;
    }

    public void setAxisPin(int AxisPin){
        this.AxisPin=AxisPin;
    }

    public void setCanaraPin(int CanaraPin){
        this.CanaraPin=CanaraPin;
    }

    public void setHDFCPin(int HDFCPin){
        this.HDFCPin=HDFCPin;
    }

    public void setAxisPinCount(int AxisPinCount){
        this.AxisPinCount=AxisPinCount;
    }

    public void setCanaraPinCount(int CanaraPinCount){
        this.CanaraPinCount=CanaraPinCount;
    }

    public void setHDFCPinCount(int HDFCPinCount){
        this.HDFCPinCount=HDFCPinCount;
    }

    public int getPhonePayPin(){
        return PhonePayPin;
    }

    public int getAxisPin(){
        return AxisPin;
    }
    
    public int getCanaraPin(){
        return CanaraPin;
    }

    public int getHDFCPin(){
        return HDFCPin;
    }

    public int getAxisPinCount(){
        return AxisPinCount;
    }

    public int getCanaraPinCount(){
        return CanaraPinCount;
    }

    public int getHDFCPinCount(){
        return HDFCPinCount;
    }


    public static PhoneMain PhonePayObject(){
        if(Payobject == null){
            Payobject = new PhoneMain();
        }
        return Payobject;
    }


}

