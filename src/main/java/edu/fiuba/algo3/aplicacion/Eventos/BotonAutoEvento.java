package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.PantallaElegirVehiculoYJugadorView;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonAutoEvento implements EventHandler<ActionEvent> {

    private App app;
    private TextField nombre;
    private int fila;
    private Label label;
    private PantallaElegirVehiculoYJugadorView pantalla;
    private Vehiculo vehiculo;

    public BotonAutoEvento(App app, TextField texto, Label error, PantallaElegirVehiculoYJugadorView pantalla){
        this.app = app;
        this.pantalla = pantalla;
        this.nombre = texto;
        this.label = error;
    }

    public void handle(ActionEvent actionEvent){
        Ubicacion ubicacion = new Ubicacion(4, 4);
        this.vehiculo = new Auto(ubicacion);

        if (this.nombre.getText().trim().equals("")) {
            this.label.setText("Debe ingresar un nombre");
        }else{
            pantalla.guardarJugadores(nombre.getText(), this.vehiculo);
        }

    }
}
