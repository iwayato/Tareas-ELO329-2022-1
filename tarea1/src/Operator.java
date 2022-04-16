import java.io.PrintStream;
import java.util.Scanner;

public class Operator {

    private double time = 0;
    private LampControl lampControl;
    private Cloud cloud;

    public Operator(LampControl lc, Cloud cloud){
        this.lampControl = lc;
        this.cloud = cloud;
    }

    public void executeCommands(Scanner in, PrintStream out){

        out.println("Time\t" + cloud.getHeaders());
        out.println(time + "\t" + cloud.getState());

        while(in.hasNextInt()){

            time = in.nextInt();
            String string = in.next();

            if (!string.equals("L")) {
                out.println("Unexpected device:" + string);
                System.exit(-1);
            } else {
                
            }
            
            
        }

    }

}
