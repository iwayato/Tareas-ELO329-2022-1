import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{

    private Pane view;

    public LampControl(int lampChannel, Cloud cloud){
        super(lampChannel, cloud);
        view = new LampControlView(this);
    }
    
    public Pane getView(){ 
        return view;
    }
}
