package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonCamionetaEvento implements EventHandler<ActionEvent> {

    private App app;

    private TextField nombre;
    private int fila;
    private Label label;

    private Vehiculo vehiculo;

    public BotonCamionetaEvento(App app, TextField texto, Label error){
        this.app = app;
        this.nombre = texto;
        this.label = error;
    }

    public void handle(ActionEvent actionEvent){
        Ubicacion ubicacion = new Ubicacion(2, 2);
        this.vehiculo = new Camioneta(ubicacion);

        if (this.nombre.getText().trim().equals("")) {
            this.label.setText("Debe ingresar un nombre");
        }else{
            this.app.guardarJugadores(nombre.getText(), this.vehiculo);
        }

    }
}
