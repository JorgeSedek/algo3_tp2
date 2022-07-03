package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Obstaculos.SinObstaculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SinObstaculoView {


    protected Casillero casillero;
    protected SinObstaculo sinObstaculo;
    protected ImageView imagenSinObstaculo;
    public static final int ANCHO_SIN_OBSTACULO = 20;
    public static final int ALTO_SIN_OBSTACULO = 30;

    protected String imagenPath ;

    public SinObstaculoView(Casillero casillero){
        this.casillero = casillero;
        this.sinObstaculo = (SinObstaculo) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/sinObstaculo.png";
        this.imagenSinObstaculo = new ImageView(new Image(imagenPath,ANCHO_SIN_OBSTACULO , ALTO_SIN_OBSTACULO, false, false));
    }

    public ImageView dibujar(){
        imagenSinObstaculo.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * 50 + 50);
        imagenSinObstaculo.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * 50 + 50);
        return imagenSinObstaculo;
    }
}
