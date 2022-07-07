package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.InstruccionesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonInstruccionesEvento implements EventHandler<ActionEvent> {
    private App app;

    public BotonInstruccionesEvento(App app){
        this.app = app;
    }

    public void handle(ActionEvent arg0){
        InstruccionesView instruccionesView = new InstruccionesView();
        instruccionesView.leerInstrucciones();
    }

}
