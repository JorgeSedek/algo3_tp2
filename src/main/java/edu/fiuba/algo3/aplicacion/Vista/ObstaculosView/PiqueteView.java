package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PiqueteView implements ObstaculoView{
    protected Casillero casillero;
    protected Piquete piquete;
    protected ImageView imagenPiquete;
    public static final int ANCHO_PIQUETE = 20;
    public static final int ALTO_PIQUETE = 30;

    protected String imagenPath ;

    public PiqueteView(Casillero casillero){
        this.casillero = casillero;
        this.piquete = (Piquete) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/piquete.png";
        this.imagenPiquete = new ImageView(new Image(imagenPath,ANCHO_PIQUETE, ALTO_PIQUETE, false, false));
    }

    public ImageView dibujar(){
        imagenPiquete.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * 100 + 50);
        imagenPiquete.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * 100 + 50);
        return imagenPiquete;
    }
}
