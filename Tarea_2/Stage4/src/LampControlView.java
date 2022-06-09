import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;

public class LampControlView extends VBox {

    // Constructor para la vista de la lámpara
    public LampControlView(LampControl lampControl) {
    
        // Creación de los botones utilizados en el control

        // Para encender la lámpara
        Button PowerButton = new Button();
        // Para avanzar un canal
        Button nextLampChannel = new Button();
        // Para retroceder un canal
        Button previousLampChannel = new Button();

        // Se asigna un ícono a cada botón con fines decorativos
        PowerButton.setGraphic(new ButtonIcon("img/power_button.png", 0.0).getIcon());
        nextLampChannel.setGraphic(new ButtonIcon("img/arrow.png", 90.0).getIcon());
        previousLampChannel.setGraphic(new ButtonIcon("img/arrow.png", 270.0).getIcon());

        // Campo de texto que refleja el canal actual sobre el cual actúa el control
        TextField textField = new TextField("0");
        textField.setMaxSize(23, 30);
        textField.setScaleX(1.5);
        textField.setScaleY(1.5);
        textField.setTranslateX(71);

        // Creación de los sliders para controlar el valor rgb de las lámparas
        Slider rSlider = new Slider();
        Slider gSlider = new Slider();
        Slider bSlider = new Slider();

        // Etiquetas para identificar cada slider
        Label redCaption = new Label("Red:");
        Label greenCaption = new Label("Green:");
        Label blueCaption = new Label("Blue:");

        // Configuración para cada slider : definir valor min y valor max (0 y 255 respectivamente)
        rSlider.setMin(0);
        rSlider.setMax(255);
        rSlider.setValue(255);
        rSlider.setShowTickLabels(false);
        rSlider.setShowTickMarks(false);
        rSlider.setMajorTickUnit(50);
        rSlider.setMinorTickCount(5);
        rSlider.setBlockIncrement(10);
        
        gSlider.setMin(0);
        gSlider.setMax(255);
        gSlider.setValue(255);
        gSlider.setShowTickLabels(false);
        gSlider.setShowTickMarks(false);
        gSlider.setMajorTickUnit(50);
        gSlider.setMinorTickCount(5);
        gSlider.setBlockIncrement(10);
        
        bSlider.setMin(0);
        bSlider.setMax(255);
        bSlider.setValue(255);
        bSlider.setShowTickLabels(false);
        bSlider.setShowTickMarks(false);
        bSlider.setMajorTickUnit(50);
        bSlider.setMinorTickCount(5);
        bSlider.setBlockIncrement(10);

        // Etiquetas que muestran el valor actual de cada color de acuerdo a la posición del slider
        Label redValue = new Label(Double.toString(rSlider.getValue()));
        Label greenValue = new Label(Double.toString(gSlider.getValue()));
        Label blueValue = new Label(Double.toString(bSlider.getValue()));

        // Contenedor para el control de lámpara
        HBox lampControlHBox = new HBox(5.0, previousLampChannel, PowerButton, textField, nextLampChannel);
        lampControlHBox.setPadding(new Insets(10));

        // Contenedor para las etiquetas que muestran la información de interés
        HBox RedInfo = new HBox(5.0, redCaption, redValue);
        HBox GreenInfo = new HBox(5.0, greenCaption, greenValue);
        HBox BlueInfo = new HBox(5.0, blueCaption, blueValue);

        // Contenedor para los sliders
        VBox slidersVBox = new VBox(5.0, RedInfo, rSlider, GreenInfo, gSlider, BlueInfo, bSlider);
        slidersVBox.setPadding(new Insets(30, 0, 0, 10));

        // Se añaden los sliders a la escena
        getChildren().addAll(
            lampControlHBox, 
            textField, 
            slidersVBox
        );

        // Handler del botón de encendido : al hacer click sobre el se ejecuta el método que cambia el color a blanco de la 
        // parte superior de la lámpara
        PowerButton.setOnMouseClicked(e -> lampControl.pressPower(Integer.parseInt(textField.getCharacters().toString())));

        // Handler para el botón de siguiente canal : suma 1 al valor en el campo de texto 'textField'
        nextLampChannel.setOnMouseClicked(e -> 
            textField.setText(String.valueOf(Integer.parseInt(textField.getCharacters().toString()) + 1))
        );

        // Handler para el botón de canal anterior : resta 1 al valor en el campo de texto 'textField'
        previousLampChannel.setOnMouseClicked(e -> 
            textField.setText(String.valueOf(Integer.parseInt(textField.getCharacters().toString()) - 1))
        );

        // Handlers para los sliders (Listeners) : funciónes que estan 'atentas' a cambios en los valores de cada slider, si detecta un cambio
        // ejecuta la función que cambia el color de la lámpara utilizando como argumentos (para los colores) los valores actuales de cada slider
        // y para identificar  la lámpara sobre la cual actuar obtiene el valor presente en el campo de texto.
        // Cabe destacar que cuando se invoca el método 'lampControl.changeLampColors' se envía el valor nuevo detectado junto con los otros valores que 
        // se obtienen usando 'xSlider.getValue()' que retorna el valor del slider x (= r, g, b).
        rSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                lampControl.changeLampColors(Integer.parseInt(textField.getCharacters().toString()), new_val.doubleValue(), gSlider.getValue(), bSlider.getValue());
                redValue.setText(String.format("%.1f", new_val));
            }
        });

        gSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                lampControl.changeLampColors(Integer.parseInt(textField.getCharacters().toString()), rSlider.getValue(), new_val.doubleValue(), bSlider.getValue());
                greenValue.setText(String.format("%.1f", new_val));
            }
        });

        bSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                lampControl.changeLampColors(Integer.parseInt(textField.getCharacters().toString()), rSlider.getValue(), gSlider.getValue(), new_val.doubleValue());
                blueValue.setText(String.format("%.1f", new_val));
            }
        });  
    }
}
