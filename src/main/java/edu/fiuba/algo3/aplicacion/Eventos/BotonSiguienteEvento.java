package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class BotonSiguienteEvento implements EventHandler<ActionEvent> {

    private App app;
    private ChoiceBox<String> choiceBox;
    private TextField nombre;
    private int fila;
    private Label label;

    private Vehiculo vehiculo;

    public BotonSiguienteEvento(App app, ChoiceBox<String> choiceBox, TextField texto, Label error){
        this.app = app;
        this.choiceBox = choiceBox;
        this.nombre = texto;
        this.label = error;
        this.fila = fila;
    }

    public void handle(ActionEvent actionEvent){
        Ubicacion ubicacion = new Ubicacion(2, 2);

        if(this.choiceBox.getValue() == "Moto"){
            this.vehiculo = new Moto(ubicacion);
        }else if(this.choiceBox.getValue() == "Auto"){
            this.vehiculo = new Auto(ubicacion);
        }else if(this.choiceBox.getValue() == "Camioneta"){
            this.vehiculo = new Camioneta(ubicacion);
        }

        if (this.nombre.getText().trim().equals("")) {
            this.label.setText("Debe ingresar un nombre");
        }else{
            this.app.guardarJugadores(nombre.getText(), this.vehiculo);
        }

    }

}
