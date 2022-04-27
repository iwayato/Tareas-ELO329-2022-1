public class DomoticDeviceControl {

    protected Cloud cloud;
    protected int channel;

    public DomoticDeviceControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }

    public int getChannel() {
        return channel;
    }
}
