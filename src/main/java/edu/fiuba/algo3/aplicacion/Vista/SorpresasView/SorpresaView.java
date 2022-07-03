package edu.fiuba.algo3.aplicacion.Vista.SorpresasView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Sorpresas.SinSorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SorpresaView {

    private Casillero casillero;
    private Sorpresa sorpresa;
    private ImageView imagenSorpresa;
    public static double ANCHO_SORPRESA;
    public static double ALTO_SORPRESA;
    protected String imagenPath ;

    public SorpresaView(Casillero casillero, double alto, double ancho) {
        this.ANCHO_SORPRESA = ancho;
        this.ALTO_SORPRESA = alto;
        this.casillero = casillero;
        this.sorpresa = casillero.obtenerSorpresa();

        if (this.sorpresa instanceof SinSorpresa) {
            this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/sorpresaImagenes/sinSorpresa.png";
        }
        else {
            this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/sorpresaImagenes/sorpresa.png";
        }

        this.imagenSorpresa = new ImageView(new Image(imagenPath, ANCHO_SORPRESA * 0.3, ALTO_SORPRESA * 0.3, false, false));
    }
    public ImageView dibujar() {
        imagenSorpresa.setLayoutY((casillero.obtenerUbicacion().obtenerFila() - 2) * ANCHO_SORPRESA + ANCHO_SORPRESA * 1.2);
        imagenSorpresa.setLayoutX((casillero.obtenerUbicacion().obtenerColumna() - 2) * ALTO_SORPRESA + ALTO_SORPRESA * 1.2);
        return imagenSorpresa;
    }
}

