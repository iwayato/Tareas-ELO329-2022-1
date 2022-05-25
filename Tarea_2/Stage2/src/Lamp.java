import javafx.scene.Node;

public class Lamp extends DomoticDevice{

    private short r, g, b;
    private LampState state;
    private LampView view;
    
    public Lamp (int channel){
        super(channel);
        r = g = b = 255;
        state = LampState.OFF;
        view = new LampView();
    }

    public void changePowerState(){
        state = state == LampState.ON ? LampState.OFF : LampState.ON;
        if (state == LampState.OFF) view.setColor((short) 0,(short) 0, (short) 0);
        else view.setColor(r,g,b);
    }

    public Node getView() {
        return view;
    }
}
    
