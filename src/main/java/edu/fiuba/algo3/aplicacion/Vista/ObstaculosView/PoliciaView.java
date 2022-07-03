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
    public static final int ANCHO_POLICIA = 20;
    public static final int ALTO_POLICIA = 30;

    protected String imagenPath ;

    public PoliciaView(Casillero casillero){
        this.casillero = casillero;
        this.policia = (Policia) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/policiaIcono.png";
        this.imagenPolicia = new ImageView(new Image(imagenPath,ANCHO_POLICIA, ALTO_POLICIA, false, false));
    }

    public ImageView dibujar(){
        imagenPolicia.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * 50 + 50);
        imagenPolicia.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * 50 + 50);
        return imagenPolicia;
    }
}
