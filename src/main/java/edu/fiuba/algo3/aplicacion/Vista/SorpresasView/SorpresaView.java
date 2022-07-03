package edu.fiuba.algo3.aplicacion.Vista.SorpresasView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SorpresaView {

    private Casillero casillero;
    private Sorpresa sorpresa;
    private ImageView imagenSorpresa;
    public static final int ANCHO_SORPRESA = 20;
    public static final int ALTO_SORPRESA = 30;
    protected String imagenPath ;

    public SorpresaView(Casillero casillero) {
        this.casillero = casillero;
        this.sorpresa = casillero.obtenerSorpresa();
        this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/sorpresaImagenes/sorpresa.png";
        this.imagenSorpresa = new ImageView(new Image(imagenPath, ANCHO_SORPRESA, ALTO_SORPRESA, false, false));
    }
    public ImageView dibujar() {
        imagenSorpresa.setLayoutX((casillero.obtenerUbicacion().obtenerFila() - 2) * 50 + 50);
        imagenSorpresa.setLayoutY((casillero.obtenerUbicacion().obtenerColumna() - 2) * 50 + 50);
        return imagenSorpresa;
    }
}

