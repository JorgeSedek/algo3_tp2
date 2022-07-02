package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AutoView {

    protected Auto auto;
    protected Image imagenAuto;
    public static final int ANCHO_AUTO = 40;
    public static final int ALTO_AUTO = 30;

    protected String imagenPath ;

    public AutoView(Auto auto){
        this.auto = auto;
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/autoImagenes/auto2dDerecha.png";
    }
/*
    public mostrarAuto(Stage primaryStage){
        ImageView imageView = new ImageView(new Image(this.imagenPath,50, 50, false, false));

        // stack pane
        TilePane tilePane = new TilePane();

        // add ImageView to the tile pane
        tilePane.getChildren().add(imageView);

        //set up scene
        Scene scene = new Scene(tilePane, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Button obtenerBoton(int ancho, int largo){
        Button btn = new Button();
        btn.setGraphic(new ImageView(new Image(this.imagenPath,ancho, largo, false, false)));
        return btn;
    }

    public Image obtenerImagen(int ancho, int largo){
        return new Image(this.imagenPath,ancho, largo, false, false);
    }

    public Auto obtenerAuto(){
        return this.auto;
    }
*/
}
