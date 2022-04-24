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

    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;
            rs.advanceTime(delta);
        }
    }

    private DomoticDevice getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel){
        for( int i=0 ; i<devices.size() ; i++){
            if (devices.get(i).getChannel() == channel) {
                return devices.get(i);
            }
        }
        return null;
    }

    public void changeLampPowerState(int channel){
        for( int i = 0 ; i < lamps.size() ; i++){
            if (lamps.get(i).getChannel() == channel) {
                ((Lamp)lamps.get(i)).changePowerState();
            }
        }
    }

    public void startShadeUp(int channel){
        for( int i=0 ; i<rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel()==channel) {
                ((RollerShade)rollerShades.get(i)).startUp();
            }
        }
    }

    public void startShadeDown(int channel){
        for( int i=0 ; i<rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel()==channel) {
                ((RollerShade)rollerShades.get(i)).startDown();
            }
        }
    }

    public void stopShade(int channel){
        for( int i=0 ; i<rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel()==channel) {
                ((RollerShade)rollerShades.get(i)).stop();
            }
        }
    }

    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades)
            header += rs.getHeader()+"\t";
        for (DomoticDevice l: lamps)
            header += l.getHeader()+"\t";
        return header;
    }

    public String getState(){
        String state = "";
        for (DomoticDevice  rs: rollerShades)
            state += rs.toString()+"\t";
        for (DomoticDevice l: lamps)
            state += l.toString()+"\t";
        return state;
    }
}
