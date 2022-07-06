package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.PantallaInicioView.PantallaElegirVehiculoYJugadorView;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

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
        Random rand = new Random();
        int random = rand.nextInt(Escenario.getInstance().obtenerFilas()) + 1;
        while(random %2 != 0){
            random = rand.nextInt(Escenario.getInstance().obtenerFilas()) + 1;
        }
        Ubicacion ubicacion = new Ubicacion(random, 2);
        this.vehiculo = new Auto(ubicacion);

        if (this.nombre.getText().trim().equals("")) {
            this.label.setText("Debe ingresar un nombre");
        }else{
            pantalla.guardarJugadores(nombre.getText(), this.vehiculo);
        }

    }
}
