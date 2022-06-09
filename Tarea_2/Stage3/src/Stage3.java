import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage3 extends Application {

    public static void main(String[] args) {  
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        
        // Canales de los dispositivos
        int lampChannel1 = 3;
        int lampChannel2 = 2;
        int shadeChannel = 1;

        // Creación de la nube, lámparas y una cortina
        Cloud cloud = new Cloud();
        Lamp lamp1 = new Lamp(lampChannel1);
        Lamp lamp2 = new Lamp(lampChannel2);
        RollerShade rs = new RollerShade(shadeChannel, 2, 300, 100);
        // Se registran los dispositivos en la nube
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        cloud.addRollerShade(rs);

        // Creación de controles de lámpara y cortina
        LampControl lampControl = new LampControl(lampChannel1, cloud);
        ShadeControl shadeControl = new ShadeControl(shadeChannel, cloud);
        
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
        hBox3.getChildren().addAll(rs.getView());
        hBox3.setAlignment(Pos.CENTER);

        // Box para la primera lámpara
        hBox4.getChildren().addAll(lamp1.getView());
        hBox4.setAlignment(Pos.CENTER);

        // Box para ls segunda lámpara
        hBox6.getChildren().addAll(lamp2.getView());
        hBox6.setAlignment(Pos.CENTER);
    
        // Padding de los contenedores
        vBoxLeft.setPadding(new Insets(50));
        vBoxRight.setPadding(new Insets(50));
        vBoxMid.setPadding(new Insets(50));

        // Alineación de los contenedores
        vBoxLeft.setAlignment(Pos.TOP_CENTER);
        vBoxRight.setAlignment(Pos.BOTTOM_CENTER);
        vBoxMid.setAlignment(Pos.BOTTOM_CENTER);

        // Se añaden los contenedores de los elementos básicos a los contenedores principales
        vBoxLeft.getChildren().addAll(hBox1, hBox2);
        vBoxRight.getChildren().addAll(hBox3, hBox4);
        vBoxMid.getChildren().addAll(hBox5, hBox6);
        
        // Creación del Pane y asignación de contenedores a éste
        BorderPane pane = new BorderPane();
        pane.setLeft(vBoxLeft);
        pane.setRight(vBoxRight);
        pane.setCenter(vBoxMid);
        
        // Se crea la escena
        Scene scene = new Scene(pane, 850, 500);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
