import javafx.scene.Node;

public class Lamp {

    // Parámetros de la lámpara
    private int channel;
    private short r,g,b;
    private LampState state;
    private LampView view;

    // Constructor de la lámpara
    public Lamp (int channel){
        this.channel = channel;
        // Cuando se enciende por primera vez, el color es blanco
        r = g = b = 255;
        // La lámpara parte apagada
        state = LampState.OFF;
        // Visualización de la lámpara
        view = new LampView();
    }

    // Función que alterna entre estado endendido y apagado
    public void changePowerState(){
        state = state == LampState.ON ? LampState.OFF : LampState.ON;
        if (state == LampState.OFF) view.setColor((short) 0,(short) 0, (short) 0);
        // Al encenderse la lámpara, conserva el valor rgb previamente establecido
        else view.setColor(r,g,b);
    }

    // Función para obtener el canal de un dispositivo
    public int getChannel(){
        return channel;
    }

    // Vista gráfica de la lámpara
    public Node getView() {
        return view;
    }
}
