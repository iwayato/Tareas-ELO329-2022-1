import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;

public class ShadeControlView extends BorderPane {

    public ShadeControlView (ShadeControl sc){

        // Control de cortina
        ShadeControl shadeControl = sc;

        // Grid para los botones del control
        GridPane grid = new GridPane();

        // Botoón para subir cortina
        Button upButton = new Button();
        upButton.setGraphic(new ButtonIcon("img/arrow.png", 0.0).getIcon());

        // Botón para bajar cortina
        Button downButton = new Button();
        downButton.setGraphic(new ButtonIcon("img/arrow.png", 180.0).getIcon());

        // Botón que muestra el canal actual
        Button channelButton = new Button("" + sc.getChannel());

        // Ubicación de los botones en el grid
        setCenter(grid);
        grid.add(upButton, 1, 0, 1, 1);
        grid.add(downButton, 1, 2, 1, 1);
        grid.add(channelButton, 1, 1, 1, 1);
        GridPane.setHalignment(channelButton, HPos.CENTER);

        // Handler del botón para subir la cortina, ejecuta la función que sube la cortina en el control de cortinas usando como argumento
        // el número presente en el campo de texto del botón 'channelButton'
        upButton.setOnMouseClicked(e -> {
            shadeControl.startUp();
        });

        // Handler del botón para bajar la cortina, ejecuta la función que sube la cortina en el control de cortinas usando como argumento
        // el número presente en el campo de texto del botón 'channelButton'
        downButton.setOnMouseClicked(e -> {
            shadeControl.startDown();
        });

        // Handler para que al apretar el botón, se detenga la cortina
        channelButton.setOnMouseClicked(e-> {
            shadeControl.stop();
        });
    }
}
