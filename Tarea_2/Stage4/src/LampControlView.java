import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class LampControlView extends VBox {

    public LampControlView(LampControl lampControl) {

        Image img = new Image("img/power_button.png");
        ImageView icon = new ImageView(img);
        icon.setFitHeight(30);
        icon.setPreserveRatio(true);
    
        Button PowerButton = new Button();
        Button nextLampChannel = new Button("Next Channel");
        Button previousLampChannel = new Button("Previous Channel");
        PowerButton.setGraphic(icon);
        // button.setTranslateX(177);
        // button.setTranslateY(-300);
        
        TextField textField = new TextField("0");

        Slider rSlider = new Slider();
        Slider gSlider = new Slider();
        Slider bSlider = new Slider();

        rSlider.setMin(0);
        rSlider.setMax(255);
        rSlider.setValue(255);
        rSlider.setShowTickLabels(true);
        rSlider.setShowTickMarks(true);
        rSlider.setMajorTickUnit(50);
        rSlider.setMinorTickCount(5);
        rSlider.setBlockIncrement(10);

        gSlider.setMin(0);
        gSlider.setMax(255);
        gSlider.setValue(255);
        gSlider.setShowTickLabels(true);
        gSlider.setShowTickMarks(true);
        gSlider.setMajorTickUnit(50);
        gSlider.setMinorTickCount(5);
        gSlider.setBlockIncrement(10);

        bSlider.setMin(0);
        bSlider.setMax(255);
        bSlider.setValue(255);
        bSlider.setShowTickLabels(true);
        bSlider.setShowTickMarks(true);
        bSlider.setMajorTickUnit(50);
        bSlider.setMinorTickCount(5);
        bSlider.setBlockIncrement(10);

        Label redCaption = new Label("Red:");
        Label greenCaption = new Label("Green:");
        Label blueCaption = new Label("Blue:");

        Label redValue = new Label(Double.toString(rSlider.getValue()));
        Label greenValue = new Label(Double.toString(gSlider.getValue()));
        Label blueValue = new Label(Double.toString(bSlider.getValue()));

        getChildren().addAll(
            previousLampChannel, 
            PowerButton, 
            nextLampChannel, 
            textField, 
            redCaption, redValue, rSlider, 
            greenCaption, greenValue, gSlider, 
            blueCaption, blueValue, bSlider
        );

        PowerButton.setOnMouseClicked(e -> lampControl.pressPower(Integer.parseInt(textField.getCharacters().toString())));

        nextLampChannel.setOnMouseClicked(e -> 
            textField.setText(String.valueOf(Integer.parseInt(textField.getCharacters().toString()) + 1))
        );

        previousLampChannel.setOnMouseClicked(e -> 
            textField.setText(String.valueOf(Integer.parseInt(textField.getCharacters().toString()) - 1))
        );

        // implementar sliders para cambiar color de lampara usando el metodo changeLampColors de LampControl
        rSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                lampControl.changeLampColors(Integer.parseInt(textField.getCharacters().toString()), new_val.doubleValue(), gSlider.getValue(), bSlider.getValue());
                redValue.setText(String.format("%.2f", new_val));
            }
        });

        gSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                lampControl.changeLampColors(Integer.parseInt(textField.getCharacters().toString()), rSlider.getValue(), new_val.doubleValue(), bSlider.getValue());
                greenValue.setText(String.format("%.2f", new_val));
            }
        });

        bSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                lampControl.changeLampColors(Integer.parseInt(textField.getCharacters().toString()), rSlider.getValue(), gSlider.getValue(), new_val.doubleValue());
                blueValue.setText(String.format("%.2f", new_val));
            }
        });  
    }
}
