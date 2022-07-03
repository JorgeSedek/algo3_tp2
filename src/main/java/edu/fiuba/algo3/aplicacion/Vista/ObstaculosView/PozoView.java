package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PozoView extends ObstaculoView{
    protected Casillero casillero;
    protected Pozo pozo;
    protected ImageView imagenPozo;
    public static final int ANCHO_POZO = 20;
    public static final int ALTO_POZO = 30;

    protected String imagenPath ;

    public PozoView(Casillero casillero){
        this.casillero = casillero;
        this.pozo = (Pozo) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/pozo.png";
        this.imagenPozo = new ImageView(new Image(imagenPath,ANCHO_POZO, ALTO_POZO, false, false));
    }

    public ImageView dibujar(){
        imagenPozo.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * 50 + 50);
        imagenPozo.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * 50 + 50);
        return imagenPozo;
    }
}
