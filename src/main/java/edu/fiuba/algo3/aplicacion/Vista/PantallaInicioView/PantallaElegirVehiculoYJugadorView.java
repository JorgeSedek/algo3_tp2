package edu.fiuba.algo3.aplicacion.Vista.PantallaInicioView;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.*;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.JuegoView;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class PantallaElegirVehiculoYJugadorView {

    private App app;
    private int cantidad;
    private EscenarioView escenarioView;

    public PantallaElegirVehiculoYJugadorView(App app, EscenarioView escenarioView){
        this.app = app;
        this.escenarioView = escenarioView;
    }

    public void ingresarNombresYVehiculo(int cant_jugadores){

        this.cantidad = cant_jugadores;
        if(cant_jugadores > 0){
            agregarJugadores();
            this.cantidad --;
        }else{

            Logger.getInstance().activar();
            Juego.resetInstance(this.app.getJugadores());
            this.escenarioView = new EscenarioView(this.app, this.app.getStage());
            this.app.asignarEscenario(escenarioView);
            JuegoView juegoView = new JuegoView(this.app, escenarioView);

            Scene escenaJuego = new Scene(juegoView.mostrarPantallaJuego(), 1000, 1000);
            escenaJuego.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
            escenaJuego.setOnKeyPressed(new ControladorTecladoEvento(escenarioView, juegoView, this.app));

            this.app.getStage().setScene(escenaJuego);
            this.app.getStage().setFullScreen(true);
            this.app.getStage().setFullScreenExitHint("");
            this.app.getStage().show();

        }
    }

    public void agregarJugadores(){
        StackPane layout = new StackPane();
        Label pedirNombre = new Label();
        Label pedirVehiculo = new Label();
        Label error = new Label();
        TextField nombreJugador = new TextField();

        Button moto = new Button("Moto");
        Button auto = new Button("Auto");
        Button camioneta = new Button("Camioneta");

        pedirNombre.setText("Ingrese el nombre del jugador");
        pedirNombre.setAlignment(Pos.CENTER);

        pedirVehiculo.setText("Elija un vehiculo para el jugador");
        pedirVehiculo.setAlignment(Pos.CENTER);

        error.setText("");

        BotonMotoEvento botonMotoEvento = new BotonMotoEvento(this.app, nombreJugador, error, this);
        moto.setOnAction(botonMotoEvento);

        BotonAutoEvento botonAutoEvento = new BotonAutoEvento(this.app, nombreJugador, error, this);
        auto.setOnAction(botonAutoEvento);

        BotonCamionetaEvento botonCamionetaEvento = new BotonCamionetaEvento(this.app, nombreJugador, error, this);
        camioneta.setOnAction(botonCamionetaEvento);

        VBox contenedorNombre = new VBox(pedirNombre, nombreJugador);
        contenedorNombre.setAlignment(Pos.CENTER);
        contenedorNombre.setSpacing(10);

        HBox contenedorBotones = new HBox(moto, auto, camioneta);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(10);

        VBox contenedorVehiculo = new VBox(pedirVehiculo, contenedorBotones);
        contenedorVehiculo.setAlignment(Pos.CENTER);
        contenedorVehiculo.setSpacing(10);

        Button salir = new Button("Salir");
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this.app);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        HBox contenedorBoton = new HBox(salir, error, region1);
        contenedorBoton.setSpacing(0);
        contenedorBoton.setAlignment(Pos.BOTTOM_LEFT);

        VBox contenedor = new VBox(contenedorNombre, contenedorVehiculo, contenedorBoton);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);


        layout.getChildren().addAll(contenedor);
        layout.setPadding(new Insets(10));

        layout.setPrefHeight(880);
        layout.setPrefWidth(920);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        this.app.getStage().setScene(scene);
        this.app.getStage().setFullScreen(true);
        this.app.getStage().setFullScreenExitHint("");
        this.app.getStage().centerOnScreen();
    }

    public void guardarJugadores(String nombre, Vehiculo vehiculo){
        Jugador jugador = new Jugador(nombre, vehiculo);
        this.app.getJugadores().add(jugador);
        this.ingresarNombresYVehiculo(this.cantidad);
    }

}
