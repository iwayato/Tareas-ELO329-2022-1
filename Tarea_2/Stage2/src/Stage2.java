import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage2 extends Application {

    public static void main(String[] args) {  
        launch(args);  
    }
    
    public void start(Stage primaryStage) {

        int lampChannel = 1;
        int shadeChannel = 2;

        Cloud cloud = new Cloud();
        Lamp lamp = new Lamp(lampChannel);
        RollerShade rs = new RollerShade(shadeChannel, 2, 150, 100);
        cloud.addLamp(lamp);
        cloud.addRollerShade(rs);

        LampControl lampControl = new LampControl(lampChannel, cloud);
        ShadeControl shadeControl = new ShadeControl(shadeChannel,cloud);
        
        VBox vBoxLeft = new VBox(20);
        VBox vBoxRight = new VBox(20);
        vBoxLeft.setPadding(new Insets(50));
        vBoxRight.setPadding(new Insets(50));
        
        //hBox.setAlignment(Pos.CENTER);
        vBoxLeft.getChildren().addAll(shadeControl.getView(), lampControl.getView());
        vBoxRight.getChildren().addAll(rs.getView(), lamp.getView());
        
        BorderPane pane = new BorderPane();
        pane.setLeft(vBoxLeft);
        pane.setRight(vBoxRight);
        //pane.setPadding(new Insets(20));
        //pane.setBottom(hBox);
        //pane.setCenter(rs.getView());
        //hBox.getChildren().add(0,shadeControl.getView());
        
        Scene scene = new Scene(pane, 700, 400);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
