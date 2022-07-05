package edu.fiuba.algo3.aplicacion.Vista.MetaView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Meta.MetaFinal;
import edu.fiuba.algo3.modelo.Sorpresas.SinSorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MetaView {

    private Casillero casillero;
    private Meta meta;
    private ImageView imagenMeta;
    public static double ANCHO_META;
    public static double ALTO_META;
    protected String imagenPath;

    public MetaView(Casillero casillero, double alto, double ancho) {
        this.ANCHO_META = ancho;
        this.ALTO_META = alto;
        this.casillero = casillero;
        this.meta = casillero.obtenerMeta();

        if (this.meta instanceof MetaFinal) {
            this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/meta.png";
            this.imagenMeta= new ImageView(new Image(imagenPath, ANCHO_META * 0.7, ALTO_META * 0.7, false, false));
        }
        else{
            this.imagenPath = "file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/sorpresaImagenes/nada.png";
            this.imagenMeta= new ImageView(new Image(imagenPath, ANCHO_META * 0.01, ALTO_META * 0.01, false, false));
        }

    }
    public ImageView dibujar() {
        imagenMeta.setLayoutY((casillero.obtenerUbicacion().obtenerFila() - 2) * ANCHO_META + ANCHO_META * 1.2);
        imagenMeta.setLayoutX((casillero.obtenerUbicacion().obtenerColumna() - 2) * ALTO_META + ALTO_META * 1.2);
        return imagenMeta;
    }
}
