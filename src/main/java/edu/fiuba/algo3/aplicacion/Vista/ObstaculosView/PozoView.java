package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PozoView extends ObstaculoView{
    protected Casillero casillero;
    protected Pozo pozo;
    protected ImageView imagenPozo;
    public double ANCHO_POZO;
    public double ALTO_POZO;

    protected String imagenPath ;

    public PozoView(Casillero casillero, double alto, double ancho){
        this.ANCHO_POZO = alto;
        this.ALTO_POZO = ancho;
        this.casillero = casillero;
        this.pozo = (Pozo) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/pozo.png";
        this.imagenPozo = new ImageView(new Image(imagenPath,ANCHO_POZO*0.3, ALTO_POZO*0.3, false, false));
    }

    public ImageView dibujar(){
        imagenPozo.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_POZO + ANCHO_POZO*1.5);
        imagenPozo.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * ALTO_POZO + ALTO_POZO*1.5);
        return imagenPozo;
    }
}
