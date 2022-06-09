import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ShadeControlView extends BorderPane {

    public ShadeControlView (ShadeControl sc){

        // Control de cortina
        ShadeControl shadeControl = sc;

        // Grid para los botones del control
        GridPane grid = new GridPane();

        // Botón para subir cortina
        Button upButton = new Button();
        upButton.setGraphic(new ButtonIcon("img/arrow.png", 0.0).getIcon());

        // Botón para bajar cortina
        Button downButton = new Button();
        downButton.setGraphic(new ButtonIcon("img/arrow.png", 180.0).getIcon());

        // Botón para cambiar al siguiente canal
        Button nextChannelButton = new Button();
        nextChannelButton.setGraphic(new ButtonIcon("img/arrow.png", 90.0).getIcon());

        // Botón para cambiar al canal anterior
        Button previusChannelButton = new Button();
        previusChannelButton.setGraphic(new ButtonIcon("img/arrow.png", 270.0).getIcon());

        // Botón que muestra el canal actual
        Button channelButton = new Button("0");
        channelButton.setScaleX(1.5);
        channelButton.setScaleY(1.5);

        // Grid para los botones
        setCenter(grid);
        grid.add(upButton, 1, 0, 1, 1);
        grid.add(downButton, 1, 2, 1, 1);
        grid.add(nextChannelButton, 2, 1, 1, 1);
        grid.add(previusChannelButton, 0, 1, 1, 1);
        grid.add(channelButton, 1, 1, 1, 1);
        GridPane.setHalignment(channelButton, HPos.CENTER);

        // Handler del botón para subir la cortina, ejecuta la función que sube la cortina en el control de cortinas usando como argumento
        // el número presente en el campo de texto del botón 'channelButton'
        upButton.setOnMouseClicked(e -> {
            shadeControl.startUp(Integer.parseInt(channelButton.getText()));
        });

        // Handler del botón para bajar la cortina, ejecuta la función que sube la cortina en el control de cortinas usando como argumento
        // el número presente en el campo de texto del botón 'channelButton'
        downButton.setOnMouseClicked(e -> {
            shadeControl.startDown(Integer.parseInt(channelButton.getText()));
        });

        // Handler del botón para parar la cortina, ejecuta la función que sube la cortina en el control de cortinas usando como argumento
        // el número presente en el campo de texto del botón 'channelButton'
        channelButton.setOnMouseClicked(e-> {
            shadeControl.stop(Integer.parseInt(channelButton.getText()));
        });

        // Handler del botón para avanzar el canal de la cortina, ejecuta la función que avanza al siguiente canal de la cortina en el control 
        // de cortinas usando como argumento el número presente en el campo de texto del botón 'channelButton'
        nextChannelButton.setOnMouseClicked(e -> 
            channelButton.setText(String.valueOf(Integer.parseInt(channelButton.getText()) + 1))
        );

        // Handler del botón para retroceder el canal de la cortina, ejecuta la función que retrocede al anterior canal de la cortina en el control 
        // de cortinas usando como argumento el número presente en el campo de texto del botón 'channelButton'
        previusChannelButton.setOnMouseClicked(e -> 
            channelButton.setText(String.valueOf(Integer.parseInt(channelButton.getText()) - 1))
        );
    }
}
