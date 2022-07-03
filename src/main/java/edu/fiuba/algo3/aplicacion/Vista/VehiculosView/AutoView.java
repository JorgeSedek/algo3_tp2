package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AutoView implements VehiculoView{

    protected Auto auto;
    protected ImageView imagenAuto;
    protected Pane root;
    public static final int ANCHO_AUTO = 40;
    public static final int ALTO_AUTO = 30;

    protected String imagenPath ;

    public AutoView(Auto auto, Pane root){
        this.auto = auto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/autoImagenes/auto2dDerecha.png";
        this.imagenAuto = new ImageView(new Image(imagenPath,ANCHO_AUTO, ALTO_AUTO, false, false));
        this.root= root;
    }

    public void dibujar(){
        this.posicionarImagen();
        root.getChildren().add(imagenAuto);
    }

    public void posicionarImagen(){
        imagenAuto.setLayoutY((auto.obtenerUbicacion().obtenerFila() - 2 ) * 50 + 50);
        imagenAuto.setLayoutX((auto.obtenerUbicacion().obtenerColumna() - 2) * 50 + 50);

    }

    public void actualizar(){
        this.posicionarImagen();

    }
}
