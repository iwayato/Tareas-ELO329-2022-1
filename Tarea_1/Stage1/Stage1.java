import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Stage1 {
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        //System.out.println("File: " + args[0]);
        Cloud cloud = new Cloud();
        // reading <#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        in.nextInt();  // skip number of roller shades
        int numLamps = in.nextInt(); //aqui se guarda el numero de lamparas 
        in.nextInt();  // skip number of roller shade controls
        int numLampsControl = in.nextInt();//aqui se sabe el numero de controles de lampara
        // skipping <alfa0> <length0> <canal0> … <alfaN_1> <lengthN_1> <canalN_1>
        in.nextLine();
        // creating lamps according to <canal0>…..<canalL_1> for just one lamp
        int channel = in.nextInt(); //aqui se sabe el numero del canal de la lampara
        Lamp lamp = new Lamp(channel); //se crea la lampara con su respectivo canal
        cloud.addLamp(lamp);//se agrega la lampara a la nube
        // skipping creation of roller shade's controls at <canal0>
        in.nextLine();
        // creating just one lamp's control at <canal0>
        channel = in.nextInt();//aqui se sabe el numero del canal del control de la lampara
        LampControl lampControl = new LampControl(channel, cloud);//se crea el control con su respectivo canal
        Operator operator = new Operator(lampControl, cloud);
        operator.executeCommands(in, System.out);
        in.close();
    }
}
