package edu.fiuba.algo3.aplicacion.Vista;

 import edu.fiuba.algo3.aplicacion.App;
 import javafx.scene.paint.Color;
 import javafx.scene.shape.Rectangle;

public class CasilleroView extends Rectangle {

    public CasilleroView(float x, float y) {
        setWidth(App.MEDIDA_CASILLERO);
        setHeight(App.MEDIDA_CASILLERO);

        relocate(x * App.MEDIDA_CASILLERO, y * App.MEDIDA_CASILLERO);
        setFill(Color.valueOf("#008080"));
    }
}