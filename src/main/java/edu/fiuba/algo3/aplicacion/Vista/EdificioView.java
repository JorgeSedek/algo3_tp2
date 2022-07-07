package edu.fiuba.algo3.aplicacion.Vista;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EdificioView extends Rectangle {
    public double ANCHO_EDIFICIO;
    public double ALTO_EDIFICIO;

    public EdificioView(float x, float y, double height, double width, int filas, int columnas) {
        ANCHO_EDIFICIO = height/(double)filas;
        ALTO_EDIFICIO =  width/(double)columnas;

        setWidth(ANCHO_EDIFICIO);
        setHeight(ALTO_EDIFICIO);

        relocate(x * ANCHO_EDIFICIO - ANCHO_EDIFICIO, y * ALTO_EDIFICIO - ALTO_EDIFICIO);
        setFill(Color.valueOf("#008080"));
    }
}

