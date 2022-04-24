import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Stage2 {
    public static void main(String [] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }

        Scanner in = new Scanner(new File(args[0]));

        // Se Crea La Nube
        Cloud cloud = new Cloud();

        // Lectura Primera Línea : Número de Lámparas, Cortinas y Cantiadad de Controles
        int numRollershades = in.nextInt();
        int numLamps = in.nextInt();
        int numRollershadeControls = in.nextInt();
        int numLampsControls = in.nextInt();

        // Lectura Segunda Línea : Propiedades de las cortinas
        for (int i = 0; i < 3 * numRollershades; i++) {
            double alpha = in.nextDouble();
            double maxLength = in.nextDouble();
            int channel = in.nextInt();
            RollerShade rollerShade = new RollerShade(channel, alpha, maxLength);
            cloud.addRollerShade(rollerShade);
        }

        // Lectura Tercera Línea
        for (int i = 0; i < numLamps; i++) {
            int channelControlLamp = in.nextInt();
            Lamp lamp = new Lamp(channelControlLamp);
            cloud.addLamp(lamp);
        }

        //Lectura Cuarta Línea
        

        // System.out.println("next int:"+ in.nextInt()); // skip lamp's channels
        // creating just one roller shade's control at <canal0>
        channel = in.nextInt();
        ShadeControl shadeControl = new ShadeControl(channel, cloud);
        in.nextInt(); // skipping creation of lamp's control at <canal0>
        Operator operator = new Operator(cloud, shadeControl);
        operator.executeCommands(in, System.out);
        in.close();
    }
}
