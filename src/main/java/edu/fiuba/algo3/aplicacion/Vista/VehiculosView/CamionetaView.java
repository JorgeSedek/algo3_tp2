package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CamionetaView implements VehiculoView{
    protected Camioneta camioneta;
    protected Pane root;
    protected ImageView imagenCamioneta;
    public static final int ANCHO_CAMIONETA= 40;
    public static final int ALTO_CAMIONETA = 30;

    protected String imagenPath ;

    public CamionetaView(Camioneta camioneta, Pane root){
        this.camioneta = camioneta;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/camionetaImagenes/camionetaIcono.png";
        this.imagenCamioneta = new ImageView(new Image(imagenPath,ANCHO_CAMIONETA, ALTO_CAMIONETA, false, false));
        this.root = root;
    }

    public void dibujar(){
        this.posicionarImagen();
        root.getChildren().add(imagenCamioneta);

    }

    public void posicionarImagen(){
        imagenCamioneta.setLayoutY((camioneta.obtenerUbicacion().obtenerFila() - 2 ) * 50 + 50);
        imagenCamioneta.setLayoutX((camioneta.obtenerUbicacion().obtenerColumna() - 2) * 50 + 50);

    }

    public void actualizar(Direccion direccion){
        camioneta.mover(direccion);
        this.posicionarImagen();

    }
}
