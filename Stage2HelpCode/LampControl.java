public class LampControl extends DomoticDeviceControl {
    public LampControl(int channel, Cloud c){
        // ???
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
}
