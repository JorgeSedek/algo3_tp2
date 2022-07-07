package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovAbajoEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovArribaEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovDerechaEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovIzquierdaEvento;
import edu.fiuba.algo3.modelo.General.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JuegoView extends BorderPane {

    private App app;
    private EscenarioView escenarioView;

    private TextArea notificaciones;

    public JuegoView(App app, EscenarioView escenarioView){
        this.app = app;

        this.escenarioView = escenarioView;

        notificaciones = new TextArea();
    }

    public BorderPane mostrarPantallaJuego(){
        posicionarTodo();
        return this;
    }

    public void posicionarTodo(){
        this.setBotonera();
        this.setCentro();
        this.setConsola();
        this.setMenu();
    }

    private void setMenu() {
        BarraMenuView menuBar = new BarraMenuView(this.app);
        this.setTop(menuBar);
    }

    private void setConsola() {
        notificaciones.setScrollTop(Double.MIN_VALUE);
        notificaciones.setScrollLeft(Double.MAX_VALUE);

        notificaciones.setEditable(false);
        notificaciones.appendText(Logger.getInstance().escribir());
        notificaciones.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        notificaciones.setStyle("-fx-text-fill: white");
        notificaciones.setPrefHeight(1500);
        notificaciones.setId("notificaciones");
        notificaciones.setWrapText(true);

        VBox contenedorConsola = new VBox(notificaciones);
        contenedorConsola.setPrefWidth(450);
        contenedorConsola.setPrefHeight(1500);
        contenedorConsola.setStyle("-fx-background-color: black");

        this.setRight(contenedorConsola);
    }

    private void setCentro() {
        escenarioView = this.app.getEscenarioView();
        this.setCenter(escenarioView.mostrarTablero());
    }

    public void setBotonera(){
        Label movimientos = new Label();
        Button moverDer = new Button("Derecha");
        Button moverIzq = new Button("Izquierda");
        Button moverArr = new Button("Arriba");
        Button moverAbj = new Button("Abajo");

        BotonMovDerechaEvento botonMovDerechaEvento = new BotonMovDerechaEvento(escenarioView, this, app);
        moverDer.setOnAction(botonMovDerechaEvento);

        BotonMovIzquierdaEvento botonMovIzquierdaEvento = new BotonMovIzquierdaEvento(escenarioView, this, app);
        moverIzq.setOnAction(botonMovIzquierdaEvento);

        BotonMovAbajoEvento botonMovAbajoEvento = new BotonMovAbajoEvento(escenarioView, this, app);
        moverAbj.setOnAction(botonMovAbajoEvento);

        BotonMovArribaEvento botonMovArribaEvento = new BotonMovArribaEvento(escenarioView, this, app);
        moverArr.setOnAction(botonMovArribaEvento);

        VBox contenedorMovimientos = new VBox(movimientos, moverArr, moverDer, moverIzq, moverAbj);
        contenedorMovimientos.setPrefHeight(800);
        contenedorMovimientos.setPrefWidth(250);
        contenedorMovimientos.setId("contenedorMovimientos");

        this.setLeft(contenedorMovimientos);
    }

    public void limpiarConsola() {
        this.notificaciones.setText("");
    }

    public void actualizar() {
        mostrarPantallaJuego();
    }
}
