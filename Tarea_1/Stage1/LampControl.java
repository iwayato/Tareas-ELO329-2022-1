public class LampControl {

    int channel;
    private Cloud cloud;
    
    public LampControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }

    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    
    public int getChannel(){
        return channel;
    }
}
