import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {

    public LampControlView(LampControl lampControl) {
    
        Button button = new Button();
        button.setGraphic(new ButtonIcon("img/power_button.png", 0.0).getIcon());
        getChildren().addAll(button);

        button.setOnMouseClicked(e -> lampControl.pressPower());
    }
}
