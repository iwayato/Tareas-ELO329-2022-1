import java.util.ArrayList;

public class Cloud {

    private ArrayList<Lamp> lamps;
    public String getstate;
    
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }

    public void addLamp(Lamp l){
        lamps.add(l);
    }

    public Lamp getLampAtChannel(int channel){
        for(int i = 0 ; i < lamps.size() ; i++){
            Lamp lampara = lamps.get(i);
            if(lampara.getChannel() == channel){
            return lampara;
            }
        }
        return null;
    }

    public void changeLampPowerState(int channel){
        getLampAtChannel(channel).changePowerState();
    }

    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }

    public String getState(){
        for(int i = 0; i < lamps.size(); i++){
            getstate = lamps.get(i).toString();
        }
        return getstate;
    }
}
