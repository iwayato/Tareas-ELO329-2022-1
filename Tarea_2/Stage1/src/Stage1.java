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
        
        int lampChannel = 1;
        Cloud cloud = new Cloud();
        Lamp lamp = new Lamp(lampChannel);
        cloud.addLamp(lamp);
        
        LampControl lampControl = new LampControl(lampChannel, cloud);

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(lamp.getView(), lampControl.getView());

        BorderPane pane = new BorderPane();
        pane.setBottom(vBox);
        Scene scene = new Scene(pane, 400, 400);

        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}