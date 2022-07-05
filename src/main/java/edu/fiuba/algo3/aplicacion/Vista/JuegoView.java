package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovAbajoEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovArribaEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovDerechaEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonMovIzquierdaEvento;
import edu.fiuba.algo3.modelo.General.Logger;
import javafx.geometry.Insets;
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

    public JuegoView(App app, EscenarioView escenarioView){
        this.app = app;
        this.escenarioView = escenarioView;
        //this.mostrarPantallaJuego();
    }

    public BorderPane mostrarPantallaJuego(){
        posicionarTodo();
        return this;
    }

    public void posicionarTodo(){
        this.setBotonera();
        this.setCentro();
        this.setAbajo();
        this.setMenu();
    }

    private void setMenu() {
        BarraMenuView menuBar = new BarraMenuView(this.app);
        this.setTop(menuBar);
    }

    private void setAbajo() {
        TextArea etiqueta = new TextArea();
        etiqueta.setText(Logger.getInstance().escribir());
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setPrefWidth(300);
        contenedorConsola.setPrefHeight(1000);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black");

        this.setRight(contenedorConsola);
    }

    private void setCentro() {

        escenarioView = this.app.getEscenarioView();
        this.setCenter(escenarioView.mostrarTablero());
        //this.setCenter();
    }

    public void setBotonera(){
        Label movimientos = new Label();
        Button moverDer = new Button("Derecha");
        Button moverIzq = new Button("Izquierda");
        Button moverArr = new Button("Arriba");
        Button moverAbj = new Button("Abajo");

        BotonMovDerechaEvento botonMovDerechaEvento = new BotonMovDerechaEvento(escenarioView, this);
        moverDer.setOnAction(botonMovDerechaEvento);

        BotonMovIzquierdaEvento botonMovIzquierdaEvento = new BotonMovIzquierdaEvento(escenarioView, this);
        moverIzq.setOnAction(botonMovIzquierdaEvento);

        BotonMovAbajoEvento botonMovAbajoEvento = new BotonMovAbajoEvento(escenarioView, this);
        moverAbj.setOnAction(botonMovAbajoEvento);

        BotonMovArribaEvento botonMovArribaEvento = new BotonMovArribaEvento(escenarioView, this);
        moverArr.setOnAction(botonMovArribaEvento);

        VBox contenedorMovimientos = new VBox(movimientos, moverArr, moverDer, moverIzq, moverAbj);
        contenedorMovimientos.setSpacing(10);
        contenedorMovimientos.setPrefHeight(800);
        contenedorMovimientos.setPrefWidth(364);

        this.setLeft(contenedorMovimientos);
    }

    public void actualizar() {
        mostrarPantallaJuego();
    }
}
