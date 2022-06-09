import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;  

public class LampView extends Group {

    // Tres Partes que construyen una lámpara completa
    Polygon topPart = new Polygon();
    Rectangle recMid = new Rectangle();
    Rectangle recBot = new Rectangle();

    public LampView () {

        // Puntos que componen la parte superior de la lámpara
        topPart.getPoints().addAll(new Double[]{
            30.0, 0.0,
            80.0, 0.0,
            110.0, 40.0,
            0.0, 40.0
        });

        // Se trasladan las partes de la lámpara y se cambia el color de la parte inferior de ésta
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

        // Se añade la lámpara a la escena
        getChildren().addAll(topPart, recMid, recBot);
    }

    // Función para cambiar el color de la lámpara :  en este stage cuando se ejecuta ésta función
    // representa cuando la lámpara se enciende con color de luz blanca
    public void setColor(short r, short g, short b){
        topPart.setFill(Color.rgb(r, g, b));
    }
}
