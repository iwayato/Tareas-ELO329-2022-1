public abstract class DomoticDeviceControl {

    protected Cloud cloud;
    private int channel;

    public DomoticDeviceControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }

    public void pressPower(int ch){
        cloud.changeLampPowerState(ch);
    }

    public int getChannel() {
        return channel;
    }
}
