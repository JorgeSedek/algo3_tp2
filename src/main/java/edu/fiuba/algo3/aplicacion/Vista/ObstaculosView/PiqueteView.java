package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PiqueteView extends ObstaculoView{
    protected Casillero casillero;
    protected Piquete piquete;
    protected ImageView imagenPiquete;
    public double ANCHO_PIQUETE;
    public double ALTO_PIQUETE;

    protected String imagenPath ;

    public PiqueteView(Casillero casillero, double alto, double ancho){
        ANCHO_PIQUETE = alto;
        ALTO_PIQUETE = ancho;
        this.casillero = casillero;
        this.piquete = (Piquete) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/piquete.png";
        this.imagenPiquete = new ImageView(new Image(imagenPath,ANCHO_PIQUETE*0.3, ALTO_PIQUETE*0.3, false, false));
    }

    public ImageView dibujar(){
        imagenPiquete.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_PIQUETE + ANCHO_PIQUETE*1.5);
        imagenPiquete.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * ALTO_PIQUETE + ALTO_PIQUETE*1.5);
        return imagenPiquete;
    }
}
