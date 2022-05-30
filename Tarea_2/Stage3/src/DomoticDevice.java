public abstract class DomoticDevice {

    private int channel;

    public DomoticDevice(int ch){
        channel = ch;
    }

    public int getChannel(){
        return channel;
    }

    public void setChannel(int ch){ 
        channel= ch;
    }
}
