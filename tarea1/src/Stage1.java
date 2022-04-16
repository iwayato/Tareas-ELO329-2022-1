import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Stage1 {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }

        Scanner inputFile = new Scanner(new File(args[0]));
        Cloud cloud = new Cloud();

        // Numero de dispositivos y sus respectivos controles
        //int numCurtains = inputFile.nextInt();
        int numLamps = inputFile.nextInt();
        //int numCurtainsControls = inputFile.nextInt();
        //int numLampsControls = inputFile.nextInt();

        // Skip propiedades de las cortinas
        inputFile.nextLine();

        // Canales lamparas
        for (int i = 0; i < numLamps; i++) {
            int channelLamp = inputFile.nextInt();
            Lamp lamp = new Lamp(channelLamp);
            cloud.addLamp(lamp);
        }

        // Skip canales controles cortinas
        inputFile.nextLine();

        // Canales de los controles
        for (int i = 0; i < numLamps; i++) {
            int channelControlLamp = inputFile.nextInt();
            LampControl lampControl = new LampControl(channelControlLamp, cloud);
            Operator operator = new Operator(lampControl, cloud);
        }
        
        // Se crea un operador
        operator.executeCommands(inputFile, System.out);

    }
}
