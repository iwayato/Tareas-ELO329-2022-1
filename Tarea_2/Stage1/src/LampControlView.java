import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {

    // Constructor para la vista de la lámpara
    public LampControlView(LampControl lampControl) {

        // Ícono para el botón de encendido
        Image img = new Image("img/power_button.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setPreserveRatio(true);
    
        // Botón que enciende o apagada la lámpara
        Button button = new Button();
        getChildren().addAll(button);
        button.setTranslateX(177);
        button.setTranslateY(-300);
        button.setGraphic(view);
        
        // Handler del botón de encendido : al hacer click sobre el se ejecuta el método que cambia el color a blanco de la 
        // parte superior de la lámpara
        button.setOnMouseClicked(e -> lampControl.pressPower());
    }
}
