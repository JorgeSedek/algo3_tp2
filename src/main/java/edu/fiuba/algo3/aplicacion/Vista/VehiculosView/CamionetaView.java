package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CamionetaView implements VehiculoView{
    protected Camioneta camioneta;
    protected ImageView imagenCamioneta;
    public static final int ANCHO_CAMIONETA= 40;
    public static final int ALTO_CAMIONETA = 30;

    protected String imagenPath ;

    public CamionetaView(Camioneta camioneta){
        this.camioneta = camioneta;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/camionetaImagenes/camionetaIcono.png";
        this.imagenCamioneta = new ImageView(new Image(imagenPath,ANCHO_CAMIONETA, ALTO_CAMIONETA, false, false));
    }

    public ImageView dibujar(){
        imagenCamioneta.setLayoutX((camioneta.obtenerUbicacion().obtenerFila() - 2 ) * 100 + 50);
        imagenCamioneta.setLayoutY((camioneta.obtenerUbicacion().obtenerColumna() - 2) * 100 + 57);
        return imagenCamioneta;
    }
}
