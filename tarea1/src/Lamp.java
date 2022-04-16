public class Lamp {

    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;

    public Lamp (int channel){
        this.channel = channel;
    }

    {
        id=nextId++;
        System.out.println(id);
    }

    public int getChannel(){
        return channel;
    }

    public void changePowerState(){
       if (state == LampState.ON) {
           state = LampState.OFF;
       } else {
           state = LampState.ON;
       }
    }

    public String getHeader(){
       return "getHeader";
    }

    public String toString(){
        if (state == LampState.ON)
            return r + "\t" + g + "\t" + b;
        else
            return "0\t0\t0";
    }
}
