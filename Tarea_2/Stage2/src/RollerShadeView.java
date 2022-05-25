import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color) {
        Rectangle background = new Rectangle(5,5, width-10,maxLength-5);
        background.setFill(Color.BLUE);  // I chose Blue
        getChildren().add(background);

        cloth = new Rectangle (/* ¿?*/);
        cloth.setFill(color);
        getChildren().add(cloth);

        // Rolled up shade cloth
        Ellipse rightSide = new Ellipse(width, radius,radius/2,radius);
        rightSide.setFill(color);
        rightSide.setStroke(Color.BLACK);
        //¿?
    }
    public void setLength(double length) {
        // ¿?
    }
    private Rectangle cloth;
}
