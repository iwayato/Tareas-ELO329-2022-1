import java.util.ArrayList;

public class Cloud {

    private ArrayList<Lamp> lamps; // getting ready for next stages

    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }

    public void addLamp(Lamp l){
        lamps.add(l);
    }

    public Lamp getLampAtChannel(int channel){
        
        for (Lamp lamp : lamps) {
            if (lamp.getChannel() == channel) {
                return lamp;
            }
        }

        return null;
    }

    public void changeLampPowerState(int channel){

        for (Lamp lamp : lamps) {
            if (lamp.getChannel() == channel) {
                lamp.changePowerState();
            }
        }
        
    }

    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }

    public String getState(){
        return "Tiempo";
    }
}
