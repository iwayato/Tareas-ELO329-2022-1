import java.io.File;
import java.io.IOException;
import java.util.*;

public class Stage1 {
    public static void main(String[] args) throws IOException {

        // En caso de no añadir argumentos
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <inputFile.txt>");
            System.exit(-1);
        }

        Scanner inputFile = new Scanner(new File(args[0]));
        List<String> inputLines = new ArrayList<String>();
        
        while (inputFile.hasNext()) {
            // Se añade el contenido del archivo a la lista inputLines
            inputLines.add(inputFile.nextLine());
        }

        // Se crea la nube
        //Cloud cloud = new Cloud();

        for (int i = 0; i < 5; i++) {
            
            // Se convierte cada linea del archivo en un Array
            List<String> arrayLine = new ArrayList<String>(Arrays.asList(inputLines.get(i).split("   ")));

            switch (i) {
                // Línea 1 : donde se definen el numero de cortinas y lámparas
                case 0:
                    try {
                        int numCortinas = Integer.parseInt(arrayLine.get(0));
                        int numLamparas = Integer.parseInt(arrayLine.get(1));
                        int numControlCortinas = Integer.parseInt(arrayLine.get(2));
                        int numControlLamparas = Integer.parseInt(arrayLine.get(3));
                        System.out.println(String.format("Numero de Cortinas : %d", numCortinas));
                        System.out.println(String.format("Numero de Lamparas : %d", numLamparas));
                        System.out.println(String.format("Numero de Controles de Cortinas : %d", numControlCortinas));
                        System.out.println(String.format("Numero de Controles de Lamparas : %d", numControlLamparas));
                    } catch (Exception e) {
                        System.out.println("Cantidad no valida para numero de dispositivos");
                    }
                    break;
                // Línea 2 : donde se definen los parámetros de cada cortina
                case 1:
                    break;
                // Línea 3 : donde se definen los canales de las lámparas
                case 2:
                    break;
                // Línea 4 : donde se definen los canales de los controles de las cortinas
                case 3:
                    break;
                // Línea 5 : donde se definen los canales de los controles de las lámparas
                case 4:
                    break;
            }
        }
    }
}
