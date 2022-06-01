import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage4 extends Application {

    public static void main(String[] args) {  
        launch(args);
    }

    public void start(Stage primaryStage) {

        // String cssLayout = 
        //     "-fx-border-color: black;\n" +
        //     "-fx-border-insets: 5;\n" +
        //     "-fx-border-width: 2;\n";
        
        int lampChannel1 = 2;
        int lampChannel2 = 3;
        int shadeChannel1 = 1;
        int shadeChannel2 = 4;

        Cloud cloud = new Cloud();
        Lamp lamp1 = new Lamp(lampChannel1);
        Lamp lamp2 = new Lamp(lampChannel2);
        RollerShade rs1 = new RollerShade(shadeChannel1, 2, 300, 170);
        RollerShade rs2 = new RollerShade(shadeChannel2, 2, 300, 170);
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        cloud.addRollerShade(rs1);
        cloud.addRollerShade(rs2);

        LampControl lampControl = new LampControl(lampChannel1, cloud);
        ShadeControl shadeControl = new ShadeControl(shadeChannel1, cloud);
        
        VBox vBoxLeft = new VBox(20);
        VBox vBoxRight = new VBox(20);
        VBox vBoxMid = new VBox(20);

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();

        hBox1.getChildren().addAll(shadeControl.getView());
        hBox1.setAlignment(Pos.CENTER);
        //hBox1.setStyle(cssLayout);

        hBox2.getChildren().addAll(lampControl.getView());
        hBox2.setAlignment(Pos.CENTER);
        //hBox2.setStyle(cssLayout);

        hBox3.getChildren().addAll(rs1.getView());
        hBox3.setAlignment(Pos.CENTER);
        //hBox3.setStyle(cssLayout);

        hBox4.getChildren().addAll(lamp1.getView());
        hBox4.setAlignment(Pos.CENTER);
        //hBox4.setStyle(cssLayout);

        hBox5.getChildren().addAll(rs2.getView());
        hBox5.setAlignment(Pos.CENTER);
        //hBox5.setStyle(cssLayout);

        hBox6.getChildren().addAll(lamp2.getView());
        hBox6.setAlignment(Pos.CENTER);
        //hBox6.setStyle(cssLayout);
    
        vBoxLeft.setPadding(new Insets(50));
        vBoxRight.setPadding(new Insets(50));
        vBoxMid.setPadding(new Insets(50));

        // vBoxLeft.setStyle(cssLayout);
        // vBoxRight.setStyle(cssLayout);
        // vBoxMid.setStyle(cssLayout);

        vBoxLeft.setAlignment(Pos.TOP_CENTER);
        vBoxRight.setAlignment(Pos.TOP_CENTER);
        vBoxMid.setAlignment(Pos.TOP_CENTER);

        vBoxLeft.getChildren().addAll(hBox1, hBox2);
        vBoxRight.getChildren().addAll(hBox3, hBox4);
        vBoxMid.getChildren().addAll(hBox5, hBox6);
        
        BorderPane pane = new BorderPane();
        pane.setLeft(vBoxLeft);
        pane.setRight(vBoxRight);
        pane.setCenter(vBoxMid);
        
        //pane.setPadding(new Insets(20));
        //pane.setBottom(hBox);
        //pane.setCenter(rs.getView());
        //hBox.getChildren().add(0,shadeControl.getView());
        
        Scene scene = new Scene(pane, 1200, 500);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
