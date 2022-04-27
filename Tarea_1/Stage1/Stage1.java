import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Stage1 {
    public static void main(String [] args) throws IOException {

        // En caso de que no se ingrese un archivo como argumento
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }

        Scanner in = new Scanner(new File(args[0]));

        // Se crea la nube
        Cloud cloud = new Cloud();

        // Se salta el número de cortinas
        in.nextInt();

        // Número de Lámparas
        int numLamps = in.nextInt();

        // Se salta el número de Controles de Cortina
        in.nextInt();

        // Número de Controles de Lámpara
        int numLampsControl = in.nextInt();

        // Se saltan las propiedades de las Cortinas, dado que no se utilizarán cortinas
        in.nextLine();

        // Canal de la Lámpara
        int lampChannel = in.nextInt();

        // Se crea la Lámpara con su respectivo canal
        if (numLamps == 1) {
            Lamp lamp = new Lamp(lampChannel); 
            // Se añade la Lámpara a la Nube
            cloud.addLamp(lamp);
        }
        else {
            System.out.println("En esta etapa sólo se permite una lámpara");
            System.exit(-1);
        }

        // Se saltan los canales de los Controles de Cortina
        in.nextLine();

        // Canal del Control de Lámpara
        int controlLampChannel = in.nextInt();

        // Se crea el control de Lámpara en su respectivo Canal
        if (numLampsControl == 1) {
            LampControl lampControl = new LampControl(controlLampChannel, cloud);
            // Se crea el Operador, que ejecuta las acciones del archivo de entrada
            Operator operator = new Operator(lampControl, cloud);
            // Se ejecutan los comandos del archivo
            operator.executeCommands(in, System.out);
        } else {
            System.out.println("En esta etapa sólo se permite una lámpara");
            System.exit(-1);
        }

        // Se cierra el archivo de entrada
        in.close();
    }
}
