package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Policia;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PoliciaView extends ObstaculoView{

    protected Casillero casillero;
    protected Policia policia;
    protected ImageView imagenPolicia;
    public double ANCHO_POLICIA;
    public double ALTO_POLICIA;

    protected String imagenPath ;

    public PoliciaView(Casillero casillero, double alto, double ancho){
        this.ANCHO_POLICIA = alto;
        this.ALTO_POLICIA = ancho;
        this.casillero = casillero;
        this.policia = (Policia) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/policiaIcono.png";
        this.imagenPolicia = new ImageView(new Image(imagenPath,ANCHO_POLICIA*0.6, ALTO_POLICIA*0.6, false, false));
    }

    public ImageView dibujar(){
        imagenPolicia.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_POLICIA + ANCHO_POLICIA*1.2);
        imagenPolicia.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * ALTO_POLICIA + ALTO_POLICIA*1.2);
        return imagenPolicia;
    }
}
