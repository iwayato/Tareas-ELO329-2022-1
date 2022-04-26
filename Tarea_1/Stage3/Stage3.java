import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Stage3 {
    public static void main(String [] args) throws IOException {
        
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        
        // comentario
        Scanner in = new Scanner(new File(args[0]));
        in.useLocale(Locale.ENGLISH);

        // Se Crea La Nube
        Cloud cloud = new Cloud();
        Operator operator = new Operator(cloud);

        // Lectura Primera Línea : Número de Lámparas, Cortinas y Cantiadad de Controles
        int numRollershades = in.nextInt();
        int numLamps = in.nextInt();
        int numRollershadeControls = in.nextInt();
        int numLampsControls = in.nextInt();

        // Lectura Segunda Línea : Propiedades de las cortinas
        for (int i = 0; i < numRollershades; i++) {
            double alpha = in.nextDouble();
            double maxLength = in.nextDouble();
            int channel = in.nextInt();
            RollerShade rollerShade = new RollerShade(channel, alpha, maxLength);
            cloud.addRollerShade(rollerShade);
        }

        // Lectura Tercera Línea : Canales de las Lámparas
        for (int i = 0; i < numLamps; i++) {
            int channelControlLamp = in.nextInt();
            Lamp lamp = new Lamp(channelControlLamp);
            cloud.addLamp(lamp);
        }

        // Lectura Cuarta Línea : Canales de los Controles de Cortinas
        for (int i = 0; i < numRollershadeControls; i++) {
            int channelControlRollerShade = in.nextInt();
            ShadeControl shadeControl = new ShadeControl(channelControlRollerShade, cloud);
            operator.addShadeControl(shadeControl);
        }

        // Lectura Quinta Línea
        for (int i = 0; i < numLampsControls; i++) {
            int channelControlLamp = in.nextInt();
            LampControl lampControl = new LampControl(channelControlLamp, cloud);
            operator.addLampControl(lampControl);
        }

        // Operator Lee los comandos que actúan sobre las cortinas y lámparas
        operator.executeCommands(in, System.out);

        // Se cierra el archivo de entrada
        in.close();
    }
}