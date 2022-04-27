public class RollerShade extends DomoticDevice {
    
    private Motor motor;
    private final int id;
    private static int nextId = 0;
    //private final double MaxShadeLength;
    
    public RollerShade (int channel, double alpha, double length) {
        super(channel);
        motor = new Motor(alpha, length);
        //MaxShadeLength = length;
    }

    {
        id = nextId++;
    }

    //nested class, Motor is only used within RollerShade.
    public static class Motor {

        private double alpha;
        private double increment;
        private double maxShadeLength;
        private double currentLength = 0;
        private MotorState state;
        private static double RADIUS = 0.04;
        //private double direction;

        public Motor (double a, double l){
            alpha = a;
            maxShadeLength = l;
            state = MotorState.STOPPED;
            //direction = 0;
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

            increment = alpha*delta*RADIUS;

            switch (state){
                case STOPPED:
                    //direction = 0;
                    break;
                case DOWNWARD:
                    if (currentLength + increment > maxShadeLength) {
                        break;
                    } 
                    else {
                        currentLength = currentLength + increment;
                        break;
                    }
                    //direction = -100;
                case UPWARD:
                    if (currentLength - increment < 0) {
                        break;
                    } 
                    else {
                        currentLength = currentLength - increment;
                        break;
                    }
                    //direction = 100;
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
        String s = String.valueOf(motor.currentLength);
        return s;
    }
}
