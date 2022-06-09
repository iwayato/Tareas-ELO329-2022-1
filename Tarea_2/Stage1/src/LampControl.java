import javafx.scene.layout.Pane;

public class LampControl {

    private int channel;
    private Cloud cloud;
    private Pane view;
    
    // Constructor del control de lámpara
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        cloud = c;
        view = new LampControlView(this);
    }
    
    // Función que apaga o enciende la lámpara
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    
    // Función que retorna el canal de la lámpara
    public int getChannel(){
        return channel;
    }

    // Función que retorna la vista del control de lámpara
    public Pane getView(){ 
        return view;
    }
}