public class LampControl {
    public LampControl(int _channel, Cloud c){
        channel=_channel;
        cloud=c;
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public int getChannel(){
        return channel;
    }
    int channel;
    private Cloud cloud;
}
