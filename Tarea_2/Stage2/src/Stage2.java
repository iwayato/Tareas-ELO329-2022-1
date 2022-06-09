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
        ShadeControl shadeControl = new ShadeControl(shadeChannel, cloud);
        
        VBox vBoxLeft = new VBox(20);
        VBox vBoxRight = new VBox(20);
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();

        hBox1.getChildren().addAll(shadeControl.getView());
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(20, 0, 0, 0));

        hBox2.getChildren().addAll(lampControl.getView());
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(20, 0, 0, 0));

        hBox3.getChildren().addAll(rs.getView());
        hBox3.setAlignment(Pos.CENTER);

        hBox4.getChildren().addAll(lamp.getView());
        hBox4.setAlignment(Pos.CENTER);

        vBoxLeft.setPadding(new Insets(50));
        vBoxRight.setPadding(new Insets(50));

        vBoxLeft.setAlignment(Pos.TOP_CENTER);
        vBoxRight.setAlignment(Pos.BOTTOM_CENTER);
        vBoxLeft.getChildren().addAll(hBox1, hBox2);
        vBoxRight.getChildren().addAll(hBox3, hBox4);
        
        BorderPane pane = new BorderPane();
        pane.setLeft(vBoxLeft);
        pane.setRight(vBoxRight);
        
        Scene scene = new Scene(pane, 500, 350);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
