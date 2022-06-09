import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;

public class ShadeControlView extends BorderPane {

    public ShadeControlView (ShadeControl sc){

        ShadeControl shadeControl = sc;

        GridPane grid = new GridPane();

        Button upButton = new Button();
        upButton.setGraphic(new ButtonIcon("img/arrow.png", 0.0).getIcon());

        Button downButton = new Button();
        downButton.setGraphic(new ButtonIcon("img/arrow.png", 180.0).getIcon());

        Button channelButton = new Button("" + sc.getChannel());

        setCenter(grid);
        grid.add(upButton, 1, 0, 1, 1);
        grid.add(downButton, 1, 2, 1, 1);
        grid.add(channelButton, 1, 1, 1, 1);
        GridPane.setHalignment(channelButton, HPos.CENTER);

        upButton.setOnMouseClicked(e -> {
            shadeControl.startUp();
        });

        downButton.setOnMouseClicked(e -> {
            shadeControl.startDown();
        });

        channelButton.setOnMouseClicked(e-> {
            shadeControl.stop();
        });
    }
}
