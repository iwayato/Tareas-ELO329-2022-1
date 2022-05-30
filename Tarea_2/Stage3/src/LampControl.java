import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{

    private Pane view;

    public LampControl(int lampChannel, Cloud cloud){
        super(lampChannel, cloud);
        view = new LampControlView(this);
    }
    
    public void changeLampColors(int channel, Double r, Double g, Double b){
        Lamp l = (Lamp)cloud.getLampAtChannel(channel);
        if (l == null) {
            // No debe ejecutarse nada
        } else {
            l.changeColors(r, g, b);
        }
    };
    
    public Pane getView(){ 
        return view;
    }
}
