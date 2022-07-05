package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.BotonInstruccionesEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonSalirElegirJugadoresEvent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BarraMenuView extends MenuBar {

    private App app;

    public BarraMenuView(App app){
        this.app = app;
        mostrarBarraMenu();
    }

    public void mostrarBarraMenu(){

        Menu menuArchivo = new Menu("Archivo");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        //MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionAcercaDe = new MenuItem("Instrucciones");

        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this.app);
        opcionSalir.setOnAction(botonSalir);

        BotonInstruccionesEvento opcionAcercaDeHandler = new BotonInstruccionesEvento(this.app);
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        menuArchivo.getItems().add(opcionSalir);
        menuAyuda.getItems().add(opcionAcercaDe);

        this.getMenus().addAll(menuArchivo, menuAyuda);
    }

}
