package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComenzarEvento implements EventHandler<ActionEvent> {

    private App app;

    public BotonComenzarEvento(App app){
        this.app = app;
    }

    public void handle(ActionEvent arg0){
        this.app.elegirCantidadJugadores();
    }
}
