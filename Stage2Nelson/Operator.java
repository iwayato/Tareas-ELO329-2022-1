import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(Cloud c, ShadeControl sc){
        cloud= c;
        rsControl= sc;
    }
    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            int commandTime=in.nextInt();
            while (time < commandTime) {
                out.println(time+"\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next();
            if (!device.equals("C")) {
                out.println("Unexpected device:" + device);
                System.exit(-1);
            }
            int channel = in.nextInt();
            String command=in.next();
            if (channel == rsControl.getChannel()) {
                switch (command.charAt(0)) {
                    case 'D': rsControl.startDown();
                        break;
                    case 'U': rsControl.startUp();
                        break;
                    case 'S': rsControl.stop();
                        break;
                    default: out.println("Unexpected command:" + command);
                        System.exit(-1);
                }
            }
            //in.nextLine();
        }
        out.println(time+"\t"+cloud.getState());
    }
    private double time=0;
    private ShadeControl rsControl;
    private Cloud cloud;
    private final double delta=1;
}
