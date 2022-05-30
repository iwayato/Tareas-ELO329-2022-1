import javafx.scene.Node;

public class Lamp extends DomoticDevice{

    private Double r, g, b;
    private LampState state;
    private LampView view;
    
    public Lamp (int channel){
        super(channel);
        r = g = b = 255.0;
        state = LampState.OFF;
        view = new LampView();
    }

    public void changePowerState(){
        state = state == LampState.ON ? LampState.OFF : LampState.ON;
        if (state == LampState.OFF) {
            view.setColor((Double) 0.0,(Double) 0.0, (Double) 0.0);
        }
        else {
            view.setColor(r,g,b);
        }
    }

    public void changeColors(Double red, Double green, Double blue){
        if (state == LampState.ON) {
            r = red;
            g = green;
            b = blue;
            view.setColor(r,g,b);   
        }
    };

    public Node getView() {
        return view;
    }
}
    
