// import javafx.scene.control.Button;  
// import javafx.scene.layout.StackPane;  
//import javafx.scene.PerspectiveCamera;
import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.stage.Stage;
import javafx.scene.shape.Cylinder;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.control.Button;

public class App extends Application {  
    
    public static void main(String[] args) {  
        launch(args);  
    }
    
    public enum LampState {
        ON,
        OFF
    }

    public boolean changePowerState(LampState state) {
        if (state == LampState.OFF) {
            state = LampState.ON;
            return true;
        } else {
            state = LampState.OFF;
            return false;
        }
    }
    
    private LampState st;
    
    @Override  
    public void start(Stage primaryStage) throws Exception {
        
        st = LampState.OFF;
        int xCoord = 300;
        int yCoord = 300;
        PhongMaterial matOn = new PhongMaterial();
        PhongMaterial matOff = new PhongMaterial();
        PhongMaterial matMid = new PhongMaterial();  
        PhongMaterial matBot = new PhongMaterial();
        matOn.setDiffuseColor(Color.WHITE);
        matOff.setDiffuseColor(Color.BLACK); 
        matMid.setDiffuseColor(Color.WHEAT);  
        matBot.setDiffuseColor(Color.BROWN);

        Cylinder cilTop = new Cylinder();
        Cylinder cilMid = new Cylinder();
        Cylinder cilBot = new Cylinder();

        Button button = new Button();
        button.setText("On/Off");
        button.setTranslateX(xCoord + 125);  
        button.setTranslateY(yCoord - 250);

        button.setOnMouseClicked(e -> {
            if (changePowerState(st) == true) {
                cilTop.setMaterial(matOn);
            }
            if () {
                cilTop.setMaterial(matOff);
                
            }
        });

        cilTop.setRadius(90);
        cilTop.setHeight(100);
        cilTop.setTranslateX(xCoord);
        cilTop.setTranslateY(yCoord - 125);
        cilTop.setMaterial(matOff);

        cilMid.setRadius(15);
        cilMid.setHeight(150);
        cilMid.setTranslateX(xCoord);
        cilMid.setTranslateY(yCoord);
        cilMid.setMaterial(matMid);
        
        cilBot.setRadius(50);
        cilBot.setHeight(20);
        cilBot.setTranslateX(xCoord);
        cilBot.setTranslateY(yCoord + 85);
        cilBot.setMaterial(matBot);
    
        Group root = new Group();  
        root.getChildren().addAll(cilTop, cilMid, cilBot, button);
        Scene scene = new Scene(root, 600, 600, Color.GRAY);   
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Cylinder Example");  
        primaryStage.show();  

    }
}