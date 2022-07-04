package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MotoView implements VehiculoView{
    protected Moto moto;
    protected Pane root;
    protected ImageView imagenMoto;
    public double ANCHO_MOTO;
    public double ALTO_MOTO;

    protected String imagenPath ;

    public MotoView(Moto moto, Pane root, double alto, double ancho){
        ANCHO_MOTO = ancho;
        ALTO_MOTO = alto;
        this.moto = moto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/motoImagenes/motoIcono.png";
        this.imagenMoto= new ImageView(new Image(imagenPath,ANCHO_MOTO*0.6, ALTO_MOTO*0.6, false, false));
        this.root = root;
    }

    public void dibujar(){
        this.posicionarImagen();
        root.getChildren().add(imagenMoto);
    }
    public void actualizar(){
       this.posicionarImagen();

    }

    public void posicionarImagen(){
        imagenMoto.setLayoutY((moto.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_MOTO + ANCHO_MOTO*1.2);
        imagenMoto.setLayoutX((moto.obtenerUbicacion().obtenerColumna() - 2) * ALTO_MOTO + ALTO_MOTO*1.2);

    }
}
