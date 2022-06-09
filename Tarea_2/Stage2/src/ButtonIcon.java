import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonIcon extends ImageView{

    public ImageView icon;

    public ButtonIcon (String rutaImagen, double rotation) {

        Image img = new Image(rutaImagen);
        icon = new ImageView(img);
        icon.setFitHeight(35);
        icon.setPreserveRatio(true);
        icon.setRotate(rotation);

    }

    public ImageView getIcon(){
        return icon;
    }
    
}
