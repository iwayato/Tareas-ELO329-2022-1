import java.io.File;
import java.io.IOException;
import java.util.*;

public class Stage1 {
    public static void main(String[] args) throws IOException {

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

        inputLines.forEach((Line) -> {
            List<String> arrayLine = new ArrayList<String>(Arrays.asList(Line.split("  ")));
            arrayLine.forEach((Item) -> {
                System.out.println(Item);
            });
  
        });

        

    }
}
