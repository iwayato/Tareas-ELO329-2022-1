import java.util.ArrayList;

public class Cloud {

    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }

    public void addLamp(Lamp lamp){
        lamps.add(lamp);
    }

    private ArrayList<Lamp> lamps;
}
