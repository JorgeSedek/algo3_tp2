package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.PantallaElegirCantidadJugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEscenarioChicoEvento implements EventHandler<ActionEvent> {

    private App app;

    public BotonEscenarioChicoEvento(App app){
        this.app = app;
    }

    public void handle(ActionEvent actionEvent){
        PantallaElegirCantidadJugadoresView pantallaElegirCantidadJugadoresView = new PantallaElegirCantidadJugadoresView(this.app);
        int fila = 4;
        int columna = 4;
        this.app.setFilaYColumna(fila, columna);
        pantallaElegirCantidadJugadoresView.elegirCantidadJugadores();
    }
}
