package edu.fiuba.algo3.Applicacion.Eventos;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirEvento implements EventHandler<ActionEvent> {

    public void handle(ActionEvent arg0) {
        Platform.exit();
    }
}
