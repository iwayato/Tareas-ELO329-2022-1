import javafx.scene.Group;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;  

public class LampView extends Group {

    Rectangle recTop = new Rectangle();
    Rectangle recMid = new Rectangle();
    Rectangle recBot = new Rectangle();

    public LampView () {

        recTop.setX(0);
        recTop.setY(0);

        recMid.setX(25);
        recMid.setY(60);

        recBot.setX(0);
        recBot.setY(160);

        recTop.setWidth(60);
        recTop.setHeight(60);

        recMid.setWidth(10);
        recMid.setHeight(100);
        recMid.setFill(Color.BURLYWOOD);

        recBot.setWidth(60);
        recBot.setHeight(10);
        recBot.setFill(Color.BROWN);

        getChildren().addAll(recTop, recMid, recBot);
    }

    public void setColor(Double r, Double g, Double b){
        recTop.setFill(Color.rgb(r.intValue(), g.intValue(), b.intValue()));
    }
}
