import java.util.Random;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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

        // Videos que se muestran en las 'ventanas' de las cortinas
        Media video1 = new Media(getClass().getResource("video/video1.mp4").toExternalForm());
        Media video2 = new Media(getClass().getResource("video/video2.mp4").toExternalForm());

        // Configuración general para que los videos se muestren de forma adecuada
        MediaPlayer mediaPlayer1 = new MediaPlayer(video1);
        MediaView mediaView1 = new MediaView(mediaPlayer1);
        mediaView1.setFitWidth(300);
        mediaView1.setFitHeight(170);
        mediaView1.setPreserveRatio(false);
        mediaPlayer1.setAutoPlay(true);
        mediaPlayer1.setMute(true);
        mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);

        MediaPlayer mediaPlayer2 = new MediaPlayer(video2);
        MediaView mediaView2 = new MediaView(mediaPlayer2);
        mediaView2.setFitWidth(300);
        mediaView2.setFitHeight(170);
        mediaView2.setPreserveRatio(false);
        mediaPlayer2.setAutoPlay(true);
        mediaPlayer2.setMute(true);
        mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
                
        // Los videos se añaden a una lista para que puedan ser randomizados al momento de generar la escena
        MediaView videoList[] = {mediaView1, mediaView2};
        getChildren().add(videoList[new Random().nextInt(videoList.length)]);
        
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
