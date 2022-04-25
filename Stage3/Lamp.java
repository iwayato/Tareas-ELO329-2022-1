public class Lamp extends DomoticDevice {

    private short r,g,b;
    private LampState state;
    private static int nextId = 0;

    public Lamp (int channel){
        super(nextId, channel);
        state = LampState.OFF;
        r = 255;
        g = 255;
        b = 255;
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

    public void changeColorDown(String color){
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

    public String getHeader(){
        String header= "L" + nextId + "R\tL" + nextId + "G\tL" + nextId+"B\t";
        return header;
    }

    public String toString(){
        if (state == LampState.ON)
            return "" + r + "\t" + g + "\t" + b;
        else
            return "0\t0\t0";
    }

    private enum LampState {
        ON,
        OFF
    }
}
