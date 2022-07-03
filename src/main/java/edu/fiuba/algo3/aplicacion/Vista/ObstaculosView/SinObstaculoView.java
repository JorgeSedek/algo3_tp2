package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Obstaculos.SinObstaculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SinObstaculoView extends ObstaculoView{


    protected Casillero casillero;
    protected SinObstaculo sinObstaculo;
    protected ImageView imagenSinObstaculo;
    public double ANCHO_SIN_OBSTACULO ;
    public double ALTO_SIN_OBSTACULO;

    protected String imagenPath ;

    public SinObstaculoView(Casillero casillero, double alto, double ancho){
        this.ANCHO_SIN_OBSTACULO = alto;
        this.ALTO_SIN_OBSTACULO = ancho;
        this.casillero = casillero;
        this.sinObstaculo = (SinObstaculo) casillero.obtenerObstaculo();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/obstaculoImagenes/sinObstaculo.png";
        this.imagenSinObstaculo = new ImageView(new Image(imagenPath,ANCHO_SIN_OBSTACULO*0.6 , ALTO_SIN_OBSTACULO*0.6, false, false));
    }

    public ImageView dibujar(){
        imagenSinObstaculo.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_SIN_OBSTACULO + ANCHO_SIN_OBSTACULO*1.2);
        imagenSinObstaculo.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * ALTO_SIN_OBSTACULO + ALTO_SIN_OBSTACULO*1.2);
        return imagenSinObstaculo;
    }
}
