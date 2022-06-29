package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/*
public class BotonSiguienteEvento implements EventHandler<ActionEvent> {

    private App app;
    private ChoiceBox<String> choiceBox;
    private TextField nombre;
    private Label label;

    public BotonSiguienteEvento(App app, ChoiceBox<String> choiceBox, TextField texto, Label error){
        this.app = app;
        this.choiceBox = choiceBox;
        this.nombre = texto;
        this.label = error;
    }

    public void handle(ActionEvent actionEvent){

        Vehiculo vehiculo;

        if(this.choiceBox.getValue() == "Moto"){
            vehiculo = new Moto();
        }else if(this.choiceBox.getValue() == "Auto"){
            vehiculo = new Auto();
        }else if(this.choiceBox.getValue() == "Camioneta"){
            vehiculo = new Camioneta();
        }


        if (this.nombre.getText().trim().equals("")) {
            this.label.setText("Debe ingresar un nombre");
        }else{

            this.app.guardarJugadores(nombre.getText(), vehiculo);
        }

    }

}
*/