import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {

    public LampControlView(LampControl lampControl) {

        Image img = new Image("img/power_button.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setPreserveRatio(true);
    
        Button button = new Button();
        getChildren().addAll(button);
        button.setTranslateX(175);
        button.setTranslateY(-300);
        button.setGraphic(view);
        
        button.setOnMouseClicked(e -> lampControl.pressPower());
    }
}
