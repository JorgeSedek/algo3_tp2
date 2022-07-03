package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MotoView implements VehiculoView{
    protected Moto moto;
    protected ImageView imagenMoto;
    public static final int ANCHO_MOTO= 40;
    public static final int ALTO_MOTO = 30;

    protected String imagenPath ;

    public MotoView(Moto moto){
        this.moto = moto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/motoImagenes/motoIcono.png";
        this.imagenMoto= new ImageView(new Image(imagenPath,ANCHO_MOTO, ALTO_MOTO, false, false));
    }

    public ImageView dibujar(){
        imagenMoto.setLayoutX((moto.obtenerUbicacion().obtenerFila() - 2 ) * 100 + 50);
        imagenMoto.setLayoutY((moto.obtenerUbicacion().obtenerColumna() - 2) * 100 + 57);
        return imagenMoto;
    }
}
