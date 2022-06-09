import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;  

public class LampView extends Group {

    Rectangle recTop = new Rectangle();
    Rectangle recMid = new Rectangle();
    Rectangle recBot = new Rectangle();
    Polygon topPart = new Polygon();

    public LampView () {

        topPart.getPoints().addAll(new Double[]{
            30.0, 0.0,
            80.0, 0.0,
            110.0, 40.0,
            0.0, 40.0
        });

        topPart.setTranslateX(-25.0);
        topPart.setTranslateY(20.0);

        recMid.setX(25);
        recMid.setY(60);

        recBot.setX(0);
        recBot.setY(160);

        recMid.setWidth(10);
        recMid.setHeight(100);
        recMid.setFill(Color.BURLYWOOD);

        recBot.setWidth(60);
        recBot.setHeight(10);
        recBot.setFill(Color.BROWN);

        getChildren().addAll(topPart, recMid, recBot);
    }

    public void setColor(short r, short g, short b){
        topPart.setFill(Color.rgb(r, g, b));
    }
}
