package edu.fiuba.algo3.aplicacion;

import edu.fiuba.algo3.aplicacion.Eventos.BotonComenzarEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonInstruccionesEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonSalirElegirJugadoresEvent;
import edu.fiuba.algo3.aplicacion.Eventos.BotonSalirEvento;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Jugador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private List<Jugador> jugadores;
    private Escenario escenario;
    private EscenarioView escenarioView;


    @Override
    public void start(Stage stage) {
        // Inicializacion
        this.stage = stage;
        jugadores = new ArrayList<>();

        stage.setTitle("Juego GPS");
        StackPane layout = new StackPane();
        Label integrantes = new Label("Integrantes:\n" + "Cristian Martin Lin\n" + "Martin Alejo Polese\n" + "Tomas Nahuel Olivera\n" + "Jorge Sedek\n");
        Label titulo = new Label("GPS Juego - Algo3");

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");
        Button instrucciones = new Button("Instrucciones");

        // Propiedades y setters
        comenzar.defaultButtonProperty().bind(comenzar.focusedProperty());
        salir.defaultButtonProperty().bind(salir.focusedProperty());
        instrucciones.defaultButtonProperty().bind(instrucciones.focusedProperty());

        BotonSalirEvento botonSalirEvento = new BotonSalirEvento();
        salir.setOnAction(botonSalirEvento);

        BotonComenzarEvento botonComenzarEvento = new BotonComenzarEvento(this);
        comenzar.setOnAction(botonComenzarEvento);

        BotonInstruccionesEvento botonInstruccionesEvento = new BotonInstruccionesEvento(this);
        instrucciones.setOnAction(botonInstruccionesEvento);

        StackPane.setAlignment(titulo, Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes, Pos.BOTTOM_LEFT);

        HBox botonera = new HBox(comenzar, instrucciones, salir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(10);

        VBox contenedorPrincipal = new VBox(botonera);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        layout.setPrefHeight(1080);
        layout.setPrefWidth(1920);
        layout.getChildren().addAll(contenedorPrincipal, titulo, integrantes);

        // Stage
        Image icon = new Image("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/icon.png");
        stage.getIcons().add(icon);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void salirPantallaCompleta(){
        this.stage.setFullScreen(false);
    }

    public void leerInstrucciones() {
        StackPane layout = new StackPane();
        TextArea textArea = new TextArea(
                "Gameplay\n\n"
                + "GPS es un juego de estrategia por turnos.\n"
                + "El escenario es una ciudad y el objetivo, guiar un vehículo a la meta en la menor cantidad de movimientos posibles.\n"
                + "El juego se jugará por turnos, y en cada turno el usuario decide hacia cual de las 4 esquinas posibles avanzará.\n\n"

                + "Vehiculos\n\n"
                + "El jugador podrá optar por tres diferentes tipos de vehículos:\n"
                + " * Moto\n"
                + " * Auto\n"
                + " * Camioneta\n\n"

                + "Obstáculos\n\n"
                + "Al atravesar una cuadra el jugador se podrá encontrar con alguno de los siguientes obstáculos:\n"
                + " * Pozo: Le suma 3 movimientos de penalización a autos y motos. Para una 4x4 penaliza en 2 movimientos luego de atravesar 3 pozos.\n"
                + " * Piquete: Autos y Camionetas deben pegar la vuelta, no pueden pasar. Las motos pueden pasar con una penalización de 2 movimientos.\n"
                + " * Control Policial: Para todos los vehículos la penalización es de 3 movimientos, pero la probabilidad de que sea aplicada depende del vehículo.\n\n"

                + "Sorpresas\n\n"
                + "También se podrán encontrar diferentes tipos de sorpresas:\n"
                + " * Favorable: Resta el 20% de los movimientos hechos.\n"
                + " * Desfavorable: Suma el 25% de los movimientos hechos.\n"
                + " * Cambio de Vehículo: Si es una moto, la convierte en auto. Un auto lo convierte en una Camioneta. Una camioneta la convierte en moto.\n\n"
                + "Las sorpresas figuran en el mapa como un regalo y no se sabrá que es hasta que el vehículo la accione."
        );

        textArea.setEditable(false);
        textArea.setPrefHeight(200);
        textArea.setPrefWidth(800);

        Button salir = new Button("Atras");
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        VBox vbox = new VBox(textArea, salir);
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.CENTER);

        layout.getChildren().add(vbox);
        layout.setPrefHeight(400);
        layout.setPrefWidth(800);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        this.getStage().setResizable(false);
        this.getStage().centerOnScreen();
        this.getStage().setScene(scene);


    }

    public Stage getStage(){
        return this.stage;
    }

    public EscenarioView getEscenarioView(){
        return this.escenarioView;
    }

    public List<Jugador> getJugadores(){

        return this.jugadores;
    }

    public static void main(String[] args) {
        launch();
    }

    public void setFilaYColumna(int fila, int columna) {
        Escenario.resetInstance(fila,columna);
        Escenario.getInstance().agregarObjetosRandom();
    }

}