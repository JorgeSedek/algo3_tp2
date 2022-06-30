package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonContinuarEvento implements EventHandler<ActionEvent> {

    private App app;
    private TextField fila;
    private TextField columna;
    private Label error;

    public BotonContinuarEvento(App app, TextField fila, TextField columna, Label error){
        this.app = app;
        this.fila = fila;
        this.columna = columna;
        this.error = error;
    }

    public void handle(ActionEvent actionEvent){
        if (this.fila.getText().trim().equals("") || this.fila.getText().trim().equals("")) {
            this.error.setText("Debe Ingresar Un Numero si o si");
        }else if(Integer.parseInt(fila.getText()) < 1 ||  Integer.parseInt(fila.getText()) < 1){
            this.error.setText("El numero debe ser mayor a 0");
        }else {
            this.app.setFilaYColumna(Integer.parseInt(fila.getText()), Integer.parseInt(columna.getText()));
            this.app.elegirCantidadJugadores();
        }
    }
}
