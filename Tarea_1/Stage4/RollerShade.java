public class RollerShade extends DomoticDevice {
    
    private Motor motor;
    private final int id;
    private static int nextId = 0;

    public RollerShade (int channel, double alpha, double length) {
        super(channel);
        motor = new Motor(alpha, length);
    }

    {
        id = nextId++;
    }

    public static class Motor {

        private double alpha;
        private double increment;
        private double maxShadeLength;
        private double currentLength = 0;
        private MotorState state;
        private static double RADIUS = 0.04;

        public Motor (double a, double l){
            alpha = a;
            maxShadeLength = l;
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

            increment = alpha*delta*RADIUS;

            switch (state){
                case STOPPED:
                    break;
                case DOWNWARD:
                    if (currentLength + increment > maxShadeLength) {
                        break;
                    } 
                    else {
                        currentLength = currentLength + increment;
                        break;
                    }
                case UPWARD:
                    if (currentLength - increment < 0) {
                        break;
                    } 
                    else {
                        currentLength = currentLength - increment;
                        break;
                    }
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
        String s = String.valueOf(Math.round((motor.currentLength/motor.maxShadeLength)*100));
        return s;
    }
}
