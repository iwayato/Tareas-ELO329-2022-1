public abstract class DomoticDeviceControl {

    protected Cloud cloud;
    private int channel;

    public DomoticDeviceControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }

    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }

    public int getChannel() {
        return channel;
    }
}
