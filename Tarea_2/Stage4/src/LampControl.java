import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{

    private Pane view;

    // Constructor del control de lámpara
    public LampControl(int lampChannel, Cloud cloud){
        super(lampChannel, cloud);
        view = new LampControlView(this);
    }
    
    // Función para cambiar el color de la parte superior de la lámpara según los argumentos r, g y b
    public void changeLampColors(int channel, Double r, Double g, Double b){
        // Se obtiene la lámpara en el canal 'channel'
        Lamp l = (Lamp)cloud.getLampAtChannel(channel);
        if (l == null) {
            // No debe ejecutarse nada
        } else {
            // En caso de que la lámpara retornada si exista
            l.changeColors(r, g, b);
        }
    };

    // Función para encender o apagar la lámpara
    public void pressPower(int ch){
        cloud.changeLampPowerState(ch);
    }
    
    // Función que retorna la vista del control de lámpara
    public Pane getView(){ 
        return view;
    }
}
