public class DomoticDeviceControl {
    public DomoticDeviceControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }
    public int getChannel() {
        return channel;
    }
    protected Cloud cloud;
    private int channel;
}
