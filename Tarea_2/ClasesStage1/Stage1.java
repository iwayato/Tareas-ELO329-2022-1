import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Stage1 extends Application {
    public void start(Stage primaryStage) {
        int lampChannel=1;
        Cloud cloud = new Cloud();
        Lamp lamp = new Lamp(lampChannel);
        cloud.addLamp(lamp);
        LampControl lampControl = new LampControl(lampChannel, cloud);
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp.getView(), lampControl.getView());
        BorderPane pane = new BorderPane();
        pane.setBottom(hBox);
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
