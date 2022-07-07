package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirElegirJugadoresEvent implements EventHandler<ActionEvent> {

    private App app;

    public BotonSalirElegirJugadoresEvent(App app){
        this.app = app;
    }

    public void handle(ActionEvent actionEvent){
        this.app.obtenerReproductorMusica().stop();
        this.app.start(this.app.getStage());
    }

}
