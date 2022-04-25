import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Operator {

    private double time = 0;
    private final double delta = 0.1;
    private Cloud cloud;
    private ArrayList<DomoticDeviceControl> lampControls;
    private ArrayList<DomoticDeviceControl> rollerShadesControls;

    public Operator(Cloud c){
        cloud = c;
        lampControls = new ArrayList<DomoticDeviceControl>();
        rollerShadesControls = new ArrayList<DomoticDeviceControl>();
    }

    public void addLampControl(LampControl lampControl){
        lampControls.add(lampControl);
    }

    public void addShadeControl(ShadeControl shadeControl){
        rollerShadesControls.add(shadeControl);
    }

    public void executeCommands(Scanner in, PrintStream out){

        out.println("Time\t" + cloud.getHeaders());

        while(in.hasNextInt()){

            int commandTime = in.nextInt();

            while (time < commandTime){
                out.println(time + "\t" + cloud.getState());
                cloud.advanceTime(delta);
                time += delta;
            }

            // Se Define sobre que dispositivo Actuar (C o L)
            String device = in.next();

            // En caso de que sea Cortina
            if (device.equals("C")){

                // Canal del Dispositivo
                int channel = in.nextInt();

                // Comando a Ejecutar
                String command = in.next();

                for (DomoticDeviceControl ddc : rollerShadesControls) {
                    ShadeControl rs = (ShadeControl)ddc;
                    if (channel == rs.getChannel()){
                        switch (command.charAt(0)) {
                            case 'D': 
                                rs.startDown();
                                break;
                            case 'U': 
                                rs.startUp();
                                break;
                            case 'S': 
                                rs.stop();
                                break;
                            default: out.println("Unexpected command: " + command);
                                System.exit(-1);
                        }
                    }
                }
            }
            // En caso de que sea Lámpara
            else{
                // Canal del Dispositivo
                int channel = in.nextInt();

                // Color sobre el cual Actuar
                String colorOrPower = in.next();

                if (colorOrPower.equals("P")) {
                    for (DomoticDeviceControl ddc : lampControls) {
                        LampControl lc = (LampControl)ddc;
                        if (channel == lc.getChannel()) {
                            lc.pressPower();
                        }
                    }
                }
                else{
                    // Comando a Ejecutar
                    String command = in.next();

                    for (DomoticDeviceControl ddc : lampControls) {
                        LampControl lc = (LampControl)ddc;
                        if (channel == lc.getChannel()){
                            switch (command.charAt(0)) {
                                case 'U':
                                    lc.UpColor(colorOrPower);
                                    break;
                                case 'D':
                                    lc.DownColor(colorOrPower);
                                    break;
                                default: out.println("Unexpected command: " + command);
                                    System.exit(-1);
                            }
                        }
                    }
                }
            }
        }

        out.println(time + "\t" + cloud.getState());
    }
}