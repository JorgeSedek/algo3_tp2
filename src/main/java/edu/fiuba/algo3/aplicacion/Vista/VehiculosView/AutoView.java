package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.aplicacion.Eventos.ControladorTecladoEvento;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/autoImagenes/auto2dDerecha.png";
        this.imagenAuto = new ImageView(new Image(imagenPath,ANCHO_AUTO*0.6, ALTO_AUTO*0.6, false, false));
        this.root= root;
    }

    public void dibujar(){
        this.posicionarImagen();
/*
        // pivot point = center of rect
        Rotate rotate = new Rotate(0, 50, 50);
        Translate translate = new Translate();

        // rotate first, then move
        imagenAuto.getTransforms().addAll(translate, rotate);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(translate.xProperty(), 0d),
                        new KeyValue(translate.yProperty(), 0d), new KeyValue(rotate.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(2), new KeyValue(translate.xProperty(), 300d),
                        new KeyValue(translate.yProperty(), 500d), new KeyValue(rotate.angleProperty(), 360d)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        */
        root.getChildren().add(imagenAuto);
    }

    public void posicionarImagen(){
        imagenAuto.setLayoutY((auto.obtenerUbicacion().obtenerFila() - 2 ) * ANCHO_AUTO + ANCHO_AUTO*1.2);
        imagenAuto.setLayoutX((auto.obtenerUbicacion().obtenerColumna() - 2) * ALTO_AUTO + ALTO_AUTO*1.2);

    }

    public void actualizar(){
        this.posicionarImagen();

    }
}
