package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BarraMenuView {

    private App app;

    public BarraMenuView(App app){
        this.app = app;
    }

    public void mostrarBarraMenu(){

        Button salir = new Button("Salir");
        Label movimientos = new Label();
        Button moverDer = new Button("Derecha");
        Button moverIzq = new Button("Izquierda");
        Button moverArr = new Button("Arriba");
        Button moverAbj = new Button("Abajo");

        Button ayuda = new Button("Ayuda");

        VBox contenedorMovimientos = new VBox(movimientos, moverArr, moverDer, moverIzq, moverAbj);
        contenedorMovimientos.setSpacing(10);



    }

}
