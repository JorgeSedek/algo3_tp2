package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class CamionetaView implements VehiculoView{
    protected Camioneta camioneta;
    protected Pane root;
    protected ImageView imagenCamioneta;
    public double ANCHO_CAMIONETA;
    public double ALTO_CAMIONETA;



    protected String imagenPath ;

    public CamionetaView(Camioneta camioneta, Pane root, double alto, double ancho){
        ANCHO_CAMIONETA = ancho;
        ALTO_CAMIONETA = alto;
        this.camioneta = camioneta;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/camionetaImagenes/camionetaIcono.png";
        this.imagenCamioneta = new ImageView(new Image(imagenPath,ANCHO_CAMIONETA*0.6, ALTO_CAMIONETA*0.6, false, false));
      //  this.posicionarImagen();
        this.root = root;

    }

    public void dibujar(){
        this.posicionarImagen();
/*
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(10000), imagenCamioneta);
        //translateTransition.setInterpolator(Interpolator.LINEAR);
        int posicionX = 0;
        int posicionY = 0;
        Direccion direccion = camioneta.obtenerDireccion();

        if (direccion instanceof DireccionArriba){
                    posicionX = -100;
                    posicionY = 0;
        }

        if (direccion instanceof DireccionAbajo){
            posicionX = 100;
            posicionY = 0;

        }

        if (direccion instanceof DireccionDerecha){
            posicionX = 0;
            posicionY = 100;

        }

        if (direccion instanceof DireccionIzquierda){
            posicionX = 0;
            posicionY = -100;

        }

        translateTransition.setByX(posicionX); // aca
        translateTransition.setByY(posicionY);

        translateTransition.setCycleCount(1);
        translateTransition.play();

*/
        root.getChildren().add(imagenCamioneta);

    }









    public void posicionarImagen(){

        imagenCamioneta.setLayoutY((camioneta.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_CAMIONETA + ANCHO_CAMIONETA*1.2);
        imagenCamioneta.setLayoutX((camioneta.obtenerUbicacion().obtenerColumna() - 2) * ALTO_CAMIONETA + ALTO_CAMIONETA*1.2);


    }

    public void actualizar(){
        this.posicionarImagen();

    }
}
