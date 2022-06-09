import java.util.ArrayList;

public class Cloud {

    // Lista para la lámpara
    private ArrayList<Lamp> lamps;

    // Constructor de la nube :  clase que coordina las acciones enviadas por los controles
    // sobre los dispositivos
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }

    // Función para añadir lámparas
    public void addLamp(Lamp l){
        lamps.add(l);
    }

    // Función que obtiene la lámpara en cierto canal
    public Lamp getLampAtChannel( int channel){
        for (Lamp l: lamps)
            if (l.getChannel() == channel)
                return l;
        return null;
    }

    // Función que cambia el estado de una lámpara en cierto canal
    public void changeLampPowerState(int channel){
        Lamp l = getLampAtChannel(channel);
        if (l != null) l.changePowerState();
    }
}