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
        //System.out.println("File: " + args[0]);
        Cloud cloud = new Cloud();
        // reading <#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        int numRollerShades = in.nextInt();
        in.nextInt();  // skip number of roller shades
        int numShadeControls = in.nextInt();
        in.nextInt(); // skip number of lamp's controls
        // read <alfa0> <length0> <canal0> … <alfaN_1> <lengthN_1> <canalN_1>
        double alpha = in.nextDouble();
        double maxLength = in.nextDouble();
        int channel = in.nextInt();
        RollerShade rollerShade = new RollerShade(channel, alpha, maxLength);
        cloud.addRollerShade(rollerShade);
        System.out.println("next int:"+ in.nextInt()); // skip lamp's channels
        // creating just one roller shade's control at <canal0>
        channel = in.nextInt();
        ShadeControl shadeControl = new ShadeControl(channel, cloud);
        in.nextInt(); // skipping creation of lamp's control at <canal0>
        Operator operator = new Operator(shadeControl, cloud);
        operator.executeCommands(in, System.out);
    }
}
