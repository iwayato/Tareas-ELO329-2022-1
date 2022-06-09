import javafx.scene.Node;

public class Lamp extends DomoticDevice{

    // Parámetros de la lámpara
    private Double r, g, b;
    private LampState state;
    private LampView view;
    
    // Constructor de la lámpara
    public Lamp (int channel){
        super(channel);
        // Cuando se enciende por primera vez, el color es blanco
        r = g = b = 255.0;
        // La lámpara parte apagada
        state = LampState.OFF;
        // Visualizanción de la lámpara
        view = new LampView();
    }

    // Función que alterna entre estado encendido y apagado
    public void changePowerState(){
        state = state == LampState.ON ? LampState.OFF : LampState.ON;
        if (state == LampState.OFF) {
            view.setColor((Double) 0.0,(Double) 0.0, (Double) 0.0);
        }
        else {
            // Al encenderse la lámpara, conserva el valor rgb previamente establecido
            view.setColor(r,g,b);
        }
    }

    // Función que permite cambiar los valores rgb de la lámpara
    public void changeColors(Double red, Double green, Double blue){
        // Comprueba que la lámpara este encendida
        if (state == LampState.ON) {
            r = red;
            g = green;
            b = blue;
            view.setColor(r,g,b);   
        }
    };

    // Vista gráfica de la lámpara
    public Node getView() {
        return view;
    }
}
    
