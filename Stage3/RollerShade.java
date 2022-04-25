public class RollerShade extends DomoticDevice {
    
    private Motor motor;
    private final int id;
    private final double MaxShadeLength;
    private static int nextId = 0;
    
    public RollerShade (int channel, double alpha, double length) {
        super(channel);
        motor = new Motor(alpha, length);
        MaxShadeLength = length;
    }

    {
        id = nextId++;
    }

    //nested class, Motor is only used within RollerShade.
    public static class Motor {

        private double alpha;
        private double length;
        private MotorState state;
        private static double RADIUS = 0.04;

        public Motor (double a, double l){
            alpha = a;
            length = l;
            state = MotorState.STOPPED;
        }
        
        public static enum MotorState {
            UPWARD,
            STOPPED,
            DOWNWARD
        }

        public void turnUp(){
            state = MotorState.UPWARD;
        }

        public void turnDown(){
            state = MotorState.DOWNWARD;
        }

        public void stop(){
            state = MotorState.STOPPED;
        }

        public void advanceTime(double delta){

            double increment = alpha*delta*RADIUS;

            switch (state){
                case STOPPED: 
                    length = 0;
                    break;
                case DOWNWARD:
                    length = -100;
                    break;
                case UPWARD:
                    length = 100;
                    break;
            }
        }
    }


    public void startUp(){
        motor.turnUp();
    }

    public void startDown(){
        motor.turnDown();
    }

    public void stop(){
        motor.stop();
    }

    public void advanceTime(double delta){
        motor.advanceTime(delta);
    }

    public String getHeader(){
        String s = "RS" + id;
        return s;
    }
    
    public String toString(){
        //String s = String.valueOf(Math.round(length/MaxShadeLength*100)); // descomentar esto despues
        String s = String.valueOf(motor.length);
        return s;
    }
}
