package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AutoView {

    protected Auto auto;
    protected ImageView imagenAuto;
    public static final int ANCHO_AUTO = 40;
    public static final int ALTO_AUTO = 30;

    protected String imagenPath ;

    public AutoView(Auto auto){
        this.auto = auto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/autoImagenes/auto2dDerecha.png";
        this.imagenAuto = new ImageView(new Image(imagenPath,ANCHO_AUTO, ALTO_AUTO, false, false));
    }

    public ImageView dibujar(){
        imagenAuto.setLayoutX((auto.obtenerUbicacion().obtenerFila() - 2 ) * 100 + 50);
        imagenAuto.setLayoutY((auto.obtenerUbicacion().obtenerColumna() - 2) * 100 + 57);
        return imagenAuto;
    }
}
