package edu.fiuba.algo3.aplicacion.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonCancelarSalirEvento implements EventHandler<ActionEvent> {

    private Stage ventana;

    public BotonCancelarSalirEvento(Stage ventana){
        this.ventana = ventana;
    }

    public void handle(ActionEvent actionEvent){
        ventana.close();
    }
}
