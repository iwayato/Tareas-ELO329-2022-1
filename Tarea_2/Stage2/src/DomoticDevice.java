public abstract class DomoticDevice {
    public DomoticDevice(int ch){
        channel = ch;
    }
    public int getChannel() {
        return channel;
    }
    public void setChannel(int ch) { channel= ch;}
    private int channel;
}
