public abstract class DomoticDevice {

    private int channel;

    // Constructor de la clase padre de las lámparas y cortinas
    public DomoticDevice(int ch){
        // Se asigna un canal al dispositivo
        channel = ch;
    }

    // Se obtiene el canal al cual pertenece un dispositivo
    public int getChannel(){
        return channel;
    }

    // Función que estable el canal al cual pertenece un dispositivo
    public void setChannel(int ch){ 
        channel= ch;
    }
}
