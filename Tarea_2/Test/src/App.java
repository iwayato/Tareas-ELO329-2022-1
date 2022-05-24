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

public class App extends Application {  
  
    @Override  
    public void start(Stage primaryStage) throws Exception {

        int xCoord = 300;
        int yCoord = 300;
        PhongMaterial matTop = new PhongMaterial();
        PhongMaterial matMid = new PhongMaterial();  
        PhongMaterial matBot = new PhongMaterial();
        matTop.setDiffuseColor(Color.BROWN);  
        matMid.setDiffuseColor(Color.WHEAT);  
        matBot.setDiffuseColor(Color.BLACK);  
        
        Cylinder cilTop = new Cylinder();
        Cylinder cilMid = new Cylinder();
        Cylinder cilBot = new Cylinder();

        cilTop.setRadius(90);
        cilTop.setHeight(100);
        cilTop.setTranslateX(xCoord);
        cilTop.setTranslateY(yCoord - 125);
        cilTop.setMaterial(matTop);

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
        root.getChildren().addAll(cilTop);
        root.getChildren().addAll(cilMid);
        root.getChildren().addAll(cilBot);
        Scene scene = new Scene(root, 600, 600, Color.GRAY);   
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Cylinder Example");  
        primaryStage.show();  

    }

    public static void main(String[] args) {  
        launch(args);  
    }
    
}  