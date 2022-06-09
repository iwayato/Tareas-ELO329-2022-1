import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Clase creada por nuestro grupo con el fin de reducir la cantidad de líneas de código
// que implica asignar un ícono a un botón

public class ButtonIcon extends ImageView{

    public ImageView icon;

    // Constructor que recibe la ruta de la imagen y la rotación que se le
    // desea asignar a ésta
    public ButtonIcon (String rutaImagen, double rotation) {

        Image img = new Image(rutaImagen);
        icon = new ImageView(img);
        icon.setFitHeight(35);
        icon.setPreserveRatio(true);
        icon.setRotate(rotation);

    }

    // Se retorna el ícono para ser usado en un botón
    public ImageView getIcon(){
        return icon;
    }
    
}
