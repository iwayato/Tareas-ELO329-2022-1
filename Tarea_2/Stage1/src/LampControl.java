import javafx.scene.layout.Pane;

public class LampControl {

    private int channel;
    private Cloud cloud;
    private Pane view;
    
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        cloud = c;
        view = new LampControlView(this);
    }
    
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    
    public int getChannel(){
        return channel;
    }

    public Pane getView(){ 
        return view;
    }
}