public class LampControl extends DomoticDeviceControl {
    public LampControl(int channel, Cloud c){
        super(channel, c);
        this.channel= channel;
        cloud = c;
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }

    private int channel;
    private Cloud cloud;
}
