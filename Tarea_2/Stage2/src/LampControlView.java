import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {

    public LampControlView(LampControl lampControl) {

        Image img = new Image("img/power_button.png");
        ImageView icon = new ImageView(img);
        icon.setFitHeight(30);
        icon.setPreserveRatio(true);
    
        Button button = new Button();
        getChildren().addAll(button);
        // button.setTranslateX(177);
        // button.setTranslateY(-300);
        button.setGraphic(icon);
        
        button.setOnMouseClicked(e -> lampControl.pressPower());
    }
}
