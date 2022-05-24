import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class LampView extends Group {
    public LampView () {
        Polygon base = new Polygon();
        base.getPoints().addAll(new Double[]{
                18d, 20d,
                18d, 50d,
                13d, 50d,
                10d, 53d,
                10d, 60d,
                30d, 60d,
                30d, 53d,
                27d, 50d,
                22d, 50d,
                22d, 20d});
        base.setFill(Color.GREEN);
        // ¿?
        getChildren().addAll(base /* ¿? */);
    }
    public void setColor(short r, short g, short b){
        // ¿?
    }
    private Polygon lampshade;
}