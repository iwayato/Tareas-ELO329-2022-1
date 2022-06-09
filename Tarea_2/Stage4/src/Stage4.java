import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage4 extends Application {

    public static void main(String[] args) {  
        launch(args);
    }

    public void start(Stage primaryStage) {
        
        // Canales de los dispositivos
        int lampChannel1 = 2;
        int lampChannel2 = 3;
        int shadeChannel1 = 1;
        int shadeChannel2 = 4;

        // Labels para identificar control de lámpara y control de cortina
        Label rollerShadeControlLabel = new Label("Control de Cortinas");
        Label lampControlLabel = new Label("Control de Lámparas");
        rollerShadeControlLabel.setScaleX(1.5);
        rollerShadeControlLabel.setScaleY(1.5);
        lampControlLabel.setScaleX(1.5);
        lampControlLabel.setScaleY(1.5);

        // Creación de la nube, lámparas y cortinas
        Cloud cloud = new Cloud();
        Lamp lamp1 = new Lamp(lampChannel1);
        Lamp lamp2 = new Lamp(lampChannel2);
        RollerShade rs1 = new RollerShade(shadeChannel1, 2, 300, 170);
        RollerShade rs2 = new RollerShade(shadeChannel2, 2, 300, 170);
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        cloud.addRollerShade(rs1);
        cloud.addRollerShade(rs2);

        // Creación de controles de lámpara y cortina
        LampControl lampControl = new LampControl(lampChannel1, cloud);
        ShadeControl shadeControl = new ShadeControl(shadeChannel1, cloud);

        // Contenedores principales para elementos gráficos
        VBox vBoxLeft = new VBox(20);
        VBox vBoxRight = new VBox(20);
        VBox vBoxMid = new VBox(20);

        // Contenedores para cada elemento visual básico
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();

        // Box para el control de cortina
        hBox1.getChildren().addAll(shadeControl.getView());
        hBox1.setAlignment(Pos.CENTER);

        // Box para el control de lámpara
        hBox2.getChildren().addAll(lampControl.getView());
        hBox2.setAlignment(Pos.CENTER);

        // Box para la primera cortina
        hBox3.getChildren().addAll(rs1.getView());
        hBox3.setAlignment(Pos.CENTER);

        // Box para la primera lámpara
        hBox4.getChildren().addAll(lamp1.getView());
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setPadding(new Insets(30, 0, 0, 0));

        // Box para la segunda cortina
        hBox5.getChildren().addAll(rs2.getView());
        hBox5.setAlignment(Pos.CENTER);

        // Box para la segunda lámpara
        hBox6.getChildren().addAll(lamp2.getView());
        hBox6.setAlignment(Pos.CENTER);
        hBox6.setPadding(new Insets(30, 0, 0, 0));
    
        // Padding de los contenedores
        vBoxLeft.setPadding(new Insets(50));
        vBoxRight.setPadding(new Insets(50));
        vBoxMid.setPadding(new Insets(50));

        // Alineación de los contenedores
        vBoxLeft.setAlignment(Pos.CENTER);
        vBoxRight.setAlignment(Pos.CENTER);
        vBoxMid.setAlignment(Pos.CENTER);

        // Se añaden los contenedores de los elementos básicos a los contenedores principales
        vBoxLeft.getChildren().addAll(rollerShadeControlLabel, hBox1, lampControlLabel, hBox2);
        vBoxRight.getChildren().addAll(hBox5, hBox6);
        vBoxMid.getChildren().addAll(hBox3, hBox4);
        
        // Creación del Pane y asignación de contenedores a éste
        BorderPane pane = new BorderPane();
        pane.setLeft(vBoxLeft);
        pane.setRight(vBoxRight);
        pane.setCenter(vBoxMid);
                
        // Se crea la escena
        Scene scene = new Scene(pane, 1150, 600);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}