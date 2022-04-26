public class LampControl extends DomoticDeviceControl {

    public LampControl(int channel, Cloud cloud){
        // Llamado Constructor de la Clase Padre
        super(channel, cloud);
    }

    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }

    public void UpColor(String color){
        cloud.changeColorUp(channel, color);
    }

    public void DownColor(String color){
        cloud.changeColorDown(channel, color);
    }
}
