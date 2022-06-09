import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {

    private Rectangle cloth;

    // Función para fijar el largo de la cortina
    public void setLength(double length) {
        cloth.setHeight(length);
    }
    
    // Constructor de la vista de la cortina
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color) {

        // Rectángulo que simula la vista de la 'ventana'
        Rectangle background = new Rectangle(5, 5, width - 10, maxLength-5);
        background.setFill(Color.LIGHTBLUE);
        getChildren().add(background);
        
        // Elipses que corresponden a los 'bordes' del cilindro que enrrolla la tela de la cortina
        Ellipse rightSide = new Ellipse(width, radius, radius/2, radius);
        Ellipse leftSide = new Ellipse(0, radius, radius/2, radius);
        rightSide.setFill(Color.BLACK);
        rightSide.setStroke(Color.BLACK);
        leftSide.setFill(Color.BLACK);
        leftSide.setStroke(Color.BLACK);
        getChildren().addAll(rightSide, leftSide);

        // Se crea la tela de la cortina y se añade a la escena
        cloth = new Rectangle (0, 0, width, 8);
        cloth.setFill(color);
        getChildren().add(cloth);
    }
}
