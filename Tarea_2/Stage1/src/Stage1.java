import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage1 extends Application {

    public static void main(String[] args) {  
        launch(args);  
    }

    @Override 
    public void start(Stage primaryStage) {
        
        // Canal de la lámpara
        int lampChannel = 1;

        //Creación de la nube
        Cloud cloud = new Cloud();

        // Se añade la lámpara a la nube
        Lamp lamp = new Lamp(lampChannel);
        cloud.addLamp(lamp);
        
        // Control de la lámpara
        LampControl lampControl = new LampControl(lampChannel, cloud);

        // Contenedor de la lámpara y su control
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(lamp.getView(), lampControl.getView());

        // Creación del Pane y asignación de contenedores a éste
        BorderPane pane = new BorderPane();
        pane.setBottom(vBox);
        Scene scene = new Scene(pane, 400, 400);

        // Se crea la escena
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}