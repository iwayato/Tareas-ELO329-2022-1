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

    public LampControlView(LampControl lampControl) {
    
        Button PowerButton = new Button();
        Button nextLampChannel = new Button();
        Button previousLampChannel = new Button();
        PowerButton.setGraphic(new ButtonIcon("img/power_button.png", 0.0).getIcon());
        nextLampChannel.setGraphic(new ButtonIcon("img/arrow.png", 90.0).getIcon());
        previousLampChannel.setGraphic(new ButtonIcon("img/arrow.png", 270.0).getIcon());

        TextField textField = new TextField("0");
        textField.setMaxSize(23, 30);
        textField.setScaleX(1.5);
        textField.setScaleY(1.5);
        textField.setTranslateX(71);

        Slider rSlider = new Slider();
        Slider gSlider = new Slider();
        Slider bSlider = new Slider();

        Label redCaption = new Label("Red:");
        Label greenCaption = new Label("Green:");
        Label blueCaption = new Label("Blue:");

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

        Label redValue = new Label(Double.toString(rSlider.getValue()));
        Label greenValue = new Label(Double.toString(gSlider.getValue()));
        Label blueValue = new Label(Double.toString(bSlider.getValue()));

        HBox lampControlHBox = new HBox(5.0, previousLampChannel, PowerButton, textField, nextLampChannel);
        lampControlHBox.setPadding(new Insets(10));

        HBox RedInfo = new HBox(5.0, redCaption, redValue);
        HBox GreenInfo = new HBox(5.0, greenCaption, greenValue);
        HBox BlueInfo = new HBox(5.0, blueCaption, blueValue);

        VBox slidersVBox = new VBox(5.0, RedInfo, rSlider, GreenInfo, gSlider, BlueInfo, bSlider);
        slidersVBox.setPadding(new Insets(30, 0, 0, 10));

        getChildren().addAll(
            lampControlHBox, 
            textField, 
            slidersVBox
        );

        PowerButton.setOnMouseClicked(e -> lampControl.pressPower(Integer.parseInt(textField.getCharacters().toString())));

        nextLampChannel.setOnMouseClicked(e -> 
            textField.setText(String.valueOf(Integer.parseInt(textField.getCharacters().toString()) + 1))
        );

        previousLampChannel.setOnMouseClicked(e -> 
            textField.setText(String.valueOf(Integer.parseInt(textField.getCharacters().toString()) - 1))
        );

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
