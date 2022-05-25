import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Stage2 extends Application {

    public static void main(String[] args) {  
        launch(args);  
    }
    
    public void start(Stage primaryStage) {

        int lampChannel = 1;
        Cloud cloud = new Cloud();
        Lamp lamp = new Lamp(lampChannel);
        cloud.addLamp(lamp);

        LampControl lampControl = new LampControl(lampChannel, cloud);
        
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp.getView(), lampControl.getView());
        
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        
        int shadeChannel=2;
        
        RollerShade rs = new RollerShade(shadeChannel, 2, 150, 100);
        cloud.addRollerShade(rs);
        pane.setCenter(rs.getView());
        ShadeControl shadeControl = new ShadeControl(shadeChannel,cloud);
        
        hBox.getChildren().add(0,shadeControl.getView());
        
        Scene scene = new Scene(pane, 300, 350);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
