public class Lamp extends DomoticDevice {
    public Lamp (int channel){
        // ???
    }
    public void changePowerState(){
        // ???
    }
    public String getHeader(){
        // ???
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }
    private enum LampState {
        ON,
        OFF
    }
    private short r,g,b;
    private LampState state;
    private static int nextId=0;
}
