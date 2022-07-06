package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AutoView implements VehiculoView{

    protected Auto auto;
    protected ImageView imagenAuto;
    protected Pane root;
    public double ANCHO_AUTO;
    public double ALTO_AUTO;

    protected String imagenPath ;

    public AutoView(Auto auto, Pane root, double alto, double ancho){
        ANCHO_AUTO = ancho;
        ALTO_AUTO = alto;
        this.auto = auto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/auto.png";
        this.imagenAuto = new ImageView(new Image(imagenPath,ANCHO_AUTO, ALTO_AUTO, false, false));
        this.root= root;
    }

    public void dibujar(){
        this.posicionarImagen();
        root.getChildren().add(imagenAuto);
    }

    public void posicionarImagen(){
        imagenAuto.setLayoutY((auto.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_AUTO + ANCHO_AUTO);
        imagenAuto.setLayoutX((auto.obtenerUbicacion().obtenerColumna() - 2) * ALTO_AUTO + ALTO_AUTO);

    }

    public void actualizar(){
        this.posicionarImagen();

    }

    public void moverDerecha(){

    }

}
