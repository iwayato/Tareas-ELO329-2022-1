import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{

    private Pane view;

    // Constructor del control de lámpara
    public LampControl(int lampChannel, Cloud cloud){
        super(lampChannel, cloud);
        view = new LampControlView(this);
    }
    
    // Función que retorna la vista del control de lámpara
    public Pane getView(){ 
        return view;
    }
}
