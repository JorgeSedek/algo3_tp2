package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EdificioView extends Rectangle{
        public static final int ANCHO_EDIFICIO = 50;
        public static final int ALTO_EDIFICIO = 50;

        public EdificioView(float x, float y) {
            setWidth(ANCHO_EDIFICIO) ;
            setHeight(ALTO_EDIFICIO);

            relocate(x * ANCHO_EDIFICIO, y * ALTO_EDIFICIO);
            setFill(Color.valueOf("#008080"));
        }
    }

