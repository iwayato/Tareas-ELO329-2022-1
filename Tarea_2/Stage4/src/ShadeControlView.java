import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ShadeControlView extends BorderPane {

    public ShadeControlView (ShadeControl sc){

        ShadeControl shadeControl = sc;

        GridPane grid = new GridPane();

        Button upButton = new Button("  Up   ");
        Button downButton = new Button("Down");
        Button nextChannelButton = new Button("Next Channel");
        Button previusChannelButton = new Button("Previus Channel");
        Button channelButton = new Button("0");

        grid.add(upButton, 1, 0, 1, 1);
        grid.add(downButton, 1, 2, 1, 1);
        grid.add(nextChannelButton, 2, 1, 1, 1);
        grid.add(previusChannelButton, 0, 1, 1, 1);
        grid.add(channelButton, 1, 1, 1, 1);

        setCenter(grid);

        // setCenter(channelButton);
        // setLeft(previusChannelButton);
        // setRight(nextChannelButton);
        // setTop(upButton);
        // setBottom(downButton);

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
