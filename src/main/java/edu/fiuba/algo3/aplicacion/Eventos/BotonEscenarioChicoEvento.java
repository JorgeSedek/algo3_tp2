package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEscenarioChicoEvento implements EventHandler<ActionEvent> {

    private App app;

    public BotonEscenarioChicoEvento(App app){
        this.app = app;
    }

    public void handle(ActionEvent actionEvent){
        int fila = 4;
        int columna = 4;
        this.app.setFilaYColumna(fila, columna);
        this.app.elegirCantidadJugadores();
    }
}
