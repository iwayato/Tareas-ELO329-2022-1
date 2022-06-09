public abstract class DomoticDeviceControl {

    protected Cloud cloud;
    private int channel;

    // Constructor de la clase padre de los controles de dispositivos
    public DomoticDeviceControl(int ch, Cloud c){
        // Se asigna canal y nube a la cual pertenece
        channel = ch;
        cloud = c;
    }

    // Función que retorna el canal al cual pertenece un control de dispositivo
    public int getChannel() {
        return channel;
    }
}
