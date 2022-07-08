package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/camioneta.png";
        this.imagenCamioneta = new ImageView(new Image(imagenPath,ANCHO_CAMIONETA, ALTO_CAMIONETA, false, false));;
        this.root = root;


    }

    public void dibujar(){

        this.posicionarImagen();
        root.getChildren().add(imagenCamioneta);

    }

    public void posicionarImagen(){

        imagenCamioneta.setLayoutY((camioneta.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_CAMIONETA + ANCHO_CAMIONETA);
        imagenCamioneta.setLayoutX((camioneta.obtenerUbicacion().obtenerColumna() - 2) * ALTO_CAMIONETA + ALTO_CAMIONETA);

    }

    public void actualizar(){
        this.posicionarImagen();

    }
}
