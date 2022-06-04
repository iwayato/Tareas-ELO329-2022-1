import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ShadeControlView extends BorderPane {

    public ShadeControlView (ShadeControl sc){

        ShadeControl shadeControl = sc;

        GridPane grid = new GridPane();

        Button upButton = new Button();
        upButton.setGraphic(new ButtonIcon("img/arrow.png", 0.0).getIcon());

        Button downButton = new Button();
        downButton.setGraphic(new ButtonIcon("img/arrow.png", 180.0).getIcon());

        Button nextChannelButton = new Button();
        nextChannelButton.setGraphic(new ButtonIcon("img/arrow.png", 90.0).getIcon());

        Button previusChannelButton = new Button();
        previusChannelButton.setGraphic(new ButtonIcon("img/arrow.png", 270.0).getIcon());

        Button channelButton = new Button("0");
        channelButton.setScaleX(1.5);
        channelButton.setScaleY(1.5);

        setCenter(grid);
        grid.add(upButton, 1, 0, 1, 1);
        grid.add(downButton, 1, 2, 1, 1);
        grid.add(nextChannelButton, 2, 1, 1, 1);
        grid.add(previusChannelButton, 0, 1, 1, 1);
        grid.add(channelButton, 1, 1, 1, 1);
        GridPane.setHalignment(channelButton, HPos.CENTER);

        upButton.setOnMouseClicked(e -> {
            shadeControl.startUp(Integer.parseInt(channelButton.getText()));
        });

        downButton.setOnMouseClicked(e -> {
            shadeControl.startDown(Integer.parseInt(channelButton.getText()));
        });

        channelButton.setOnMouseClicked(e-> {
            shadeControl.stop(Integer.parseInt(channelButton.getText()));
        });

        nextChannelButton.setOnMouseClicked(e -> 
            channelButton.setText(String.valueOf(Integer.parseInt(channelButton.getText()) + 1))
        );

        previusChannelButton.setOnMouseClicked(e -> 
            channelButton.setText(String.valueOf(Integer.parseInt(channelButton.getText()) - 1))
        );
    }
}
