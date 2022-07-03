package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonJugarEvento implements EventHandler<ActionEvent> {

    private EscenarioView escenarioView;

    public BotonJugarEvento(EscenarioView escenarioView){
        this.escenarioView = escenarioView;
    }

    public void handle(ActionEvent actionEvent){
        this.escenarioView.mostrarTablero();
    }
}
