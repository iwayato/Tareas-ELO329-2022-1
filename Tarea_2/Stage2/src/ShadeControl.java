import javafx.scene.layout.BorderPane;

public class ShadeControl extends DomoticDeviceControl{

    private ShadeControlView view;

    // Constructor del control de lámpara
    public ShadeControl(int channel, Cloud c){
        super(channel,c);
        view = new ShadeControlView(this);
    }

    // Vista del control de cortina
    public BorderPane getView(){
        return view;
    }

    // Función para subir la cortina
    public void startUp(){
        cloud.startShadeUp(getChannel());
    }

    // Función para bajar la cortina
    public void startDown(){
        cloud.startShadeDown(getChannel());
    }

    // Función para parar la cortina
    public void stop(){
        cloud.stopShade(getChannel());
    }
}
