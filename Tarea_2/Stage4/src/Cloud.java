import java.util.ArrayList;

public class Cloud {

    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;

    public Cloud() {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }

    public void addLamp(Lamp l){
        lamps.add(l);
    }

    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }

    public DomoticDevice getLampAtChannel( int channel){
        for (DomoticDevice l: lamps)
            if (l.getChannel() == channel)
                return l;
        return null;
    }

    public void changeLampPowerState(int channel){
        DomoticDevice l = getLampAtChannel(channel);
        if (l != null){
            ((Lamp) l).changePowerState();
        }
    }

    public void startShadeUp(int channel){
        for(int i = 0 ; i < rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel() == channel) {
                ((RollerShade)rollerShades.get(i)).startUp();
            }
        }
    }

    public void startShadeDown(int channel){
        for(int i = 0 ; i < rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel() == channel) {
                ((RollerShade)rollerShades.get(i)).startDown();
            }
        }
    }

    public void stopShade(int channel){
        for(int i = 0 ; i < rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel() == channel) {
                ((RollerShade)rollerShades.get(i)).stop();
            }
        }
    }
}