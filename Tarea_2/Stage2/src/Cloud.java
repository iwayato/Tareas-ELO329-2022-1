import java.util.ArrayList;

public class Cloud {

    // Lista para las lámparas y cortinas creadas
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;

    // Constructor de la nube :  clase que coordina las acciones enviadas por los controles
    // sobre los dispositivos
    public Cloud() {
        // Se inicializan las listas
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }

    // Función para añadir lámparas
    public void addLamp(Lamp l){
        lamps.add(l);
    }

    // Función para añadir cortinas
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }

    // Función que obtiene la lámpara en cierto canal
    public DomoticDevice getLampAtChannel( int channel){
        for (DomoticDevice l: lamps)
            if (l.getChannel() == channel)
                return l;
        return null;
    }

    // Función que cambia el estado de una lámpara en cierto canal
    public void changeLampPowerState(int channel){
        DomoticDevice l = getLampAtChannel(channel);
        if (l != null){
            ((Lamp) l).changePowerState();
        }
    }

    // Función que sube la cortina
    public void startShadeUp(int channel){
        for(int i = 0 ; i < rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel() == channel) {
                ((RollerShade)rollerShades.get(i)).startUp();
            }
        }
    }

    // Función que baja la cortina
    public void startShadeDown(int channel){
        for(int i = 0 ; i < rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel() == channel) {
                ((RollerShade)rollerShades.get(i)).startDown();
            }
        }
    }

    // Función que detiene la cortina
    public void stopShade(int channel){
        for(int i = 0 ; i < rollerShades.size() ; i++){
            if (rollerShades.get(i).getChannel() == channel) {
                ((RollerShade)rollerShades.get(i)).stop();
            }
        }
    }
}