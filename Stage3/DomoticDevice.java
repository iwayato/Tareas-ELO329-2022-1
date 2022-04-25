public abstract class DomoticDevice {

    public abstract String getHeader();
    
    private int channel;

    public DomoticDevice(int ch){
       this.channel = ch;
    }

    public int getChannel() {
        return channel;
    }
}
