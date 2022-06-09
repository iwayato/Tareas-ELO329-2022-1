import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {

    // Constructor para la vista de la lámpara
    public LampControlView(LampControl lampControl) {
    
        // Botón que enciende o apagada la lámpara
        Button button = new Button();
        button.setGraphic(new ButtonIcon("img/power_button.png", 0.0).getIcon());
        getChildren().addAll(button);

        // Handler del botón de encendido : al hacer click sobre el se ejecuta el método que cambia el color a blanco de la 
        // parte superior de la lámpara
        button.setOnMouseClicked(e -> lampControl.pressPower());
    }
}
