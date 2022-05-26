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

        String cssLayout = 
            "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 2;\n";
        
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
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        hBox1.getChildren().addAll(shadeControl.getView());
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setStyle(cssLayout);
        hBox2.getChildren().addAll(lampControl.getView());
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setStyle(cssLayout);
        hBox3.getChildren().addAll(rs.getView());
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setStyle(cssLayout);
        hBox4.getChildren().addAll(lamp.getView());
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setStyle(cssLayout);
        vBoxLeft.setPadding(new Insets(50));
        vBoxRight.setPadding(new Insets(50));
        vBoxLeft.setStyle(cssLayout);
        vBoxRight.setStyle(cssLayout);
        vBoxLeft.setAlignment(Pos.TOP_CENTER);
        vBoxRight.setAlignment(Pos.BOTTOM_CENTER);
        vBoxLeft.getChildren().addAll(hBox1, hBox2);
        vBoxRight.getChildren().addAll(hBox3, hBox4);
        
        BorderPane pane = new BorderPane();
        pane.setLeft(vBoxLeft);
        pane.setRight(vBoxRight);
        //pane.setPadding(new Insets(20));
        //pane.setBottom(hBox);
        //pane.setCenter(rs.getView());
        //hBox.getChildren().add(0,shadeControl.getView());
        
        Scene scene = new Scene(pane, 650, 450);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
