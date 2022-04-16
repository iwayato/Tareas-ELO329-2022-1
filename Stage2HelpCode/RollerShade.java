public class RollerShade extends DomoticDevice {

    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static int nextId;

    public RollerShade (int channel, double alpha, double length) {
        // ???
        motor = new Motor(alpha);
        // ??
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
        String s = "RS" + getId();
        return s;
    }

    public String toString(){
        String s = String.valueOf(Math.round(length/MaxShadeLength*100));
        return s;
    }
    
    private static class Motor {  //nested class, Motor is only used within RollerShade.

        private double alpha;
        private MotorState state;
        private static double RADIUS = 0.04;
        
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
        }

        public enum MotorState {
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

            double increment = alpha * delta * RADIUS;

            switch (state) {
                case STOPPED:
                    
                    break;
                case DOWNWARD:
                    //??
                    break;
                case UPWARD:
                    // ??
                    break;
            }
        }
    }
}
