import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RollerShade extends DomoticDevice {
    
    private RollerShadeView view;
    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static double RADIUS = 4;

    // Constructor de la cortina
    public RollerShade (int channel, double alpha, double width, double len) {
        super(channel);
        motor = new Motor(alpha);
        MaxShadeLength = len;
        this.length = 8;
        view = new RollerShadeView(MaxShadeLength, width, this.length, RADIUS, Color.GREEN);
    }

    // Función para obtener la vista de la cortina
    public Group getView(){
        return view;
    }

    // Función para subir la cortina
    public void startUp(){
        motor.turnUp();
    }

    // Función para bajar la cortina
    public void startDown(){
        motor.turnDown();
    }

    // Función para parar la cortina
    public void stop(){
        motor.stop();
    }
    
    // Motor de la cortina
    private class Motor implements EventHandler<ActionEvent>{  

        private double alpha;
        private MotorState state;
        private Timeline animation;
        private static final double DELTA = 0.1;

        // Constructor del motor
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;

            // Timeline permite animar la escena usando frames (ímagenes) que visualizan 
            // el estado de la cortina en dicho instante
            animation = new Timeline(new KeyFrame(Duration.millis(DELTA*1000), this));

            // La animación se ejecuta indefinidamente
            animation.setCycleCount(Timeline.INDEFINITE);
        }

        // Posibles estados para el motor
        public enum MotorState {
            UPWARD,
            STOPPED,
            DOWNWARD
        }

        // Función que acciona al motor para subir la tela de la cortina
        public void turnUp(){
            state = MotorState.UPWARD;
            animation.play();
        }

        // Función que acciona el motor para bajar la tela de la cortina
        public void turnDown(){
            state = MotorState.DOWNWARD;
            animation.play();
        }

        // Función que acciona al motor para parar el movimiento de la cortina
        public void stop(){
            state = MotorState.STOPPED;
            animation.stop();
        }
        
        // Handler de los eventos que se visualizan en la animación
        public void handle (ActionEvent event){

            // Diferencial que resta o suma al largo de la cortina 
            // en cada instante de la animación
            double increment = alpha*DELTA*RADIUS;

            // Switch case que eválua que hacer con la cortina dependiendo
            // del estado de la cortina
            switch (state) {
                case STOPPED:
                    break;
                case DOWNWARD:
                    // Si el largo más el incremento supera el largo máximo permitido
                    // el largo actual se conserva, en caso contrario se suma el diferencial
                    if (length + increment > MaxShadeLength) {
                        length = MaxShadeLength;
                    } else {
                        length = length + increment;
                    }
                    break;
                case UPWARD:
                    // Si el largo menos el incremento es menor al largo original de la cortina (0 en términos simples)
                    // el largo actual se conserva, en caso contrario se resta el diferencial
                    if (length - increment < 8) {
                        length = 8;
                    } else {
                        length = length - increment;
                    }
                    break;
            }

            // Luego de evaluar el estado del motor se aplica el resultado obtenido en el largo de la cortina
            view.setLength(length);
        }
    }
}

