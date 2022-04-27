public class ShadeControl extends DomoticDeviceControl{

    public ShadeControl(int channel, Cloud cloud){
        // Llamado al Constructor de la Clase Padre
        super(channel, cloud);
    }

    public void startUp(){
        cloud.startShadeUp(channel);
    }

    public void startDown(){
        cloud.startShadeDown(channel);
    }

    public void stop(){
        cloud.stopShade(channel);
    }
}
