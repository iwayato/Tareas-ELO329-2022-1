import javafx.scene.layout.BorderPane;

public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int channel, Cloud c){
        super(channel,c);
        view = new ShadeControlView(this);
    }
    public BorderPane getView() {return view;}
    public void startUp(){
        cloud.startShadeUp(getChannel());
    }
    public void startDown(){
        cloud.startShadeDown(getChannel());
    }
    public void stop(){
        cloud.stopShade(getChannel());
    }

    private ShadeControlView view;
}
