package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.PantallaInicioView.PantallaElegirCantidadJugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEscenarioGrandeEvento implements EventHandler<ActionEvent> {
    private App app;

    public BotonEscenarioGrandeEvento(App app){
        this.app = app;
    }

    public void handle(ActionEvent actionEvent){
        PantallaElegirCantidadJugadoresView pantallaElegirCantidadJugadoresView = new PantallaElegirCantidadJugadoresView(this.app);
        int fila = 8;
        int columna = 8;
        this.app.setFilaYColumna(fila, columna);
        pantallaElegirCantidadJugadoresView.elegirCantidadJugadores();
    }
}
