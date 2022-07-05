package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.ControladorTecladoEvento;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class JuegoView extends BorderPane {

    private App app;
    private EscenarioView escenarioView;

    public JuegoView(App app){
        this.app = app;
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
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

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
