public class Lamp extends DomoticDevice {

    private short r,g,b;
    private LampState state;
    private static int nextId=0;

    public Lamp (int channel){
        super(nextId, channel);
    } 

    private enum LampState {
        ON,
        OFF
    }

    public void changePowerState(){
        if ( state==LampState.ON ) {
           state=LampState.OFF;
        }
        else{
            state=LampState.ON;
        }
    }

    public String getHeader(){
        String header = "\tL" + nextId + "R\tL" + nextId + "G\tL" + nextId+"B\t";
        return header;
    }

    public String toString(){
        return "" + r + "\t" + g + "\t" + b;
    }
}
