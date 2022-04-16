public class Lamp {
    public Lamp (int _channel){
    channel=_channel;
    state=LampState.OFF;
    r=255;
    g=255;
    b=255;
    }
    {
        id=nextId++;
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
        if(state==LampState.ON){
            state=LampState.OFF;
        }else{
            state=LampState.ON;
        }
    }
    public String getHeader(){
       return header= "L"+id+"R\t"+"L"+id+"G\t"+"L"+id+"B\t";
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }
    public String header;
    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
