package edu.fiuba.algo3.aplicacion.Eventos;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BotonSalirEvento implements EventHandler<ActionEvent> {

    public void handle(ActionEvent arg0) {
        Stage ventanaSalida = new Stage();
        Label mensaje = new Label();
        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button("Cancelar");

        HBox botonera = new HBox(aceptar,cancelar);
        botonera.setSpacing(20);
        VBox contenedor = new VBox();

        mensaje.setText("¿Esta seguro que desea salir?");
        mensaje.setFont(new Font("Arial",14));
        aceptar.setFont(new Font("Arial",14));
        cancelar.setFont(new Font("Arial",14));

        contenedor.getChildren().addAll(mensaje,botonera);
        botonera.setAlignment(Pos.CENTER);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(20);

        BotonAceptarSalirEvento botonAceptarEventHandler = new BotonAceptarSalirEvento();
        aceptar.setOnAction(botonAceptarEventHandler);

        BotonCancelarSalirEvento botonCancelarEventHandler = new BotonCancelarSalirEvento(ventanaSalida);
        cancelar.setOnAction(botonCancelarEventHandler);


        Scene salir = new Scene(contenedor,250, 150);

        ventanaSalida.setTitle("¿Esta Seguro?");
        ventanaSalida.setScene(salir);
        ventanaSalida.show();
        ventanaSalida.setAlwaysOnTop(true);
        aceptar.requestFocus();


        //Platform.exit();
    }
}
