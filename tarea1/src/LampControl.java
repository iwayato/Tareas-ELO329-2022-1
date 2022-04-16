public class LampControl {

    private Cloud cloud;
    private int channel;

    public LampControl(int channel, Cloud cloud){
        this.channel = channel;
        this.cloud = cloud;
    }

    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }

    public int getChannel(){
        return this.channel;
    }
    
}
