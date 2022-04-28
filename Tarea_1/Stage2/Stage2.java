import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Stage2 {
    public static void main(String [] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }

        Scanner in = new Scanner(new File(args[0]));
        in.useLocale(Locale.ENGLISH);

        Cloud cloud = new Cloud();

        
        int numRollerShades = in.nextInt();
        in.nextInt();  
        int numShadeControls = in.nextInt();
        in.nextInt(); 

        
        double alpha = in.nextDouble();
        double maxLength = in.nextDouble();
        int channel = in.nextInt();

        RollerShade rollerShade = new RollerShade(channel, alpha, maxLength);
        cloud.addRollerShade(rollerShade);

        in.nextInt();

        channel = in.nextInt();
        ShadeControl shadeControl = new ShadeControl(channel, cloud);

        in.nextInt();

        Operator operator = new Operator(cloud, shadeControl);
        operator.executeCommands(in, System.out);

        in.close();
    }
}
