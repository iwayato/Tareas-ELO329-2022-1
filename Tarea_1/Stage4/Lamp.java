public class Lamp extends DomoticDevice {

    private short r,g,b;
    private final int id;
    private LampState state;
    private static int nextId = 0;

    public Lamp (int channel){
        super(channel);
        state = LampState.OFF;
        r = 255;
        g = 255;
        b = 255;
    }

    {
        id = nextId++;
    }

    public void changePowerState(){
        if (state == LampState.ON) {
            state = LampState.OFF;
        }
        else{
            state = LampState.ON;
        }
    }

    public void changeColorUp(String color){
        if (state == LampState.ON) {
            switch (color) {
                case "R":
                    r += 10;
                    if (r >= 255) {
                        r = 255;
                    }
                    break;    
                case "G":
                    g += 10;
                    if (g >= 255) {
                        g = 255;
                    }
                    break;
                case "B":
                    b += 10;
                    if (b >= 255) {
                        b = 255;
                    }
                    break;
                default: System.out.println("Unexpected command");
                System.exit(-1);
            }
        }
    }

    public void changeColorDown(String color){
        if (state == LampState.ON) {
            switch (color) {
                case "R":
                    r -= 10;
                    if (r < 0) {
                        r = 0;
                    }
                    break;    
                case "G":
                    g -= 10;
                    if (g < 0) {
                        g = 0;
                    }
                    break;
                case "B":
                    b -= 10;
                    if (b < 0) {
                        b = 0;
                    }
                    break;
                default: System.out.println("Unexpected command");
                System.exit(-1);
            }
        } 
    }

    public String getHeader(){
        String header = "L" + id + "R\tL" + id + "G\tL" + id + "B";
        return header;
    }

    public String toString(){
        return "" + r + "\t" + g + "\t" + b;
    }

    private enum LampState {
        ON,
        OFF
    }
}
