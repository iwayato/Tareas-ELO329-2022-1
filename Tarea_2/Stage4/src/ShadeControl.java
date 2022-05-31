import javafx.scene.layout.BorderPane;

public class ShadeControl extends DomoticDeviceControl{

    private ShadeControlView view;

    public ShadeControl(int channel, Cloud c){
        super(channel,c);
        view = new ShadeControlView(this);
    }

    public BorderPane getView(){
        return view;
    }

    public void startUp(int ch){
        cloud.startShadeUp(ch);
    }

    public void startDown(int ch){
        cloud.startShadeDown(ch);
    }

    public void stop(int ch){
        cloud.stopShade(ch);
    }
}
