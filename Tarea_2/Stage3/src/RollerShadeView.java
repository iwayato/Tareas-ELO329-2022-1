import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
//import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {

    private Rectangle cloth;

    public void setLength(double length) {
        cloth.setHeight(length);
    }
    
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color) {

        Rectangle background = new Rectangle(5, 5, width - 10, maxLength-5);
        background.setFill(Color.LIGHTBLUE);  // I chose Blue
        getChildren().add(background);
        
        // Rolled up shade cloth
        Ellipse rightSide = new Ellipse(width, radius, radius/2, radius);
        Ellipse leftSide = new Ellipse(0, radius, radius/2, radius);
        rightSide.setFill(Color.BLACK);
        rightSide.setStroke(Color.BLACK);
        leftSide.setFill(Color.BLACK);
        leftSide.setStroke(Color.BLACK);
        getChildren().addAll(rightSide, leftSide);

        cloth = new Rectangle (0, 0, width, 8);
        cloth.setFill(color);
        getChildren().add(cloth);
    }
}
