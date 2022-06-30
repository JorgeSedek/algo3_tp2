package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;

public class BotonAceptarEvento implements EventHandler<ActionEvent> {

    private App app;
    private ChoiceBox<Integer> choiceBox;

    public BotonAceptarEvento(App app, ChoiceBox<Integer> choiceBox){
        this.app = app;
        this.choiceBox = choiceBox;
    }

    public void handle(ActionEvent actionEvent){
        this.app.ingresarNombresYVehiculo(this.choiceBox.getValue());
    }
}
