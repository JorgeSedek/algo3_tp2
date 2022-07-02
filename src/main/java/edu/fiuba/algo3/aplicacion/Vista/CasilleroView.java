package edu.fiuba.algo3.aplicacion.Vista;

 import edu.fiuba.algo3.aplicacion.App;
 import edu.fiuba.algo3.modelo.General.Casillero;
 import javafx.scene.paint.Color;
 import javafx.scene.Group;
 import javafx.scene.shape.Rectangle;

public class CasilleroView extends Group{

    private int filas;
    private int columnas;
    private double height;
    private double width;

    public CasilleroView(int filas, int columnas, double height, double width) {
        this.filas = filas;
        this.columnas = columnas;
        this.height = height;
        this.width = width;
    }

    public void dibujarCasillero(float fila, float columna, Casillero casillero){
        float tamanioEnX = (float)width/(float)filas;
        float tamanioEnY = (float)height/(float)columnas;

    }

}