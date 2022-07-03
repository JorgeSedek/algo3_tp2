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
    public static final int ANCHO_MOTO= 40;
    public static final int ALTO_MOTO = 30;

    protected String imagenPath ;

    public MotoView(Moto moto, Pane root){
        this.moto = moto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/motoImagenes/motoIcono.png";
        this.imagenMoto= new ImageView(new Image(imagenPath,ANCHO_MOTO, ALTO_MOTO, false, false));
        this.root = root;
    }

    public void dibujar(){
        this.posicionarImagen();
        root.getChildren().add(imagenMoto);
    }
   public void actualizar(Direccion direccion){
       moto.mover(direccion);
       this.posicionarImagen();

    }

    public void posicionarImagen(){
        imagenMoto.setLayoutX((moto.obtenerUbicacion().obtenerFila() - 2 ) * 100 + 50);
        imagenMoto.setLayoutY((moto.obtenerUbicacion().obtenerColumna() - 2) * 100 + 50);

    }
}
