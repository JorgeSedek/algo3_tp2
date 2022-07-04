package edu.fiuba.algo3.aplicacion;

import edu.fiuba.algo3.aplicacion.Eventos.*;

import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.AutoView;

import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.ObstaculosView.PiqueteView;
import edu.fiuba.algo3.modelo.General.*;

//import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;

import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private List<Jugador> jugadores;
    private int cantidad;

    private int filas;

    private int columnas;

    //private double width = 1100;
    //private double height = 1100;

    //public static final int MEDIDA_CASILLERO = 50;

    //private CasilleroView[][] tableroView = new CasilleroView[(int) width][(int) height];

    //private Group casillerosView = new Group();
    //private EscenarioView escanarioView;
    private EscenarioView escenarioView;

    @Override
    public void start(Stage stage) {
        // Inicializacion
        this.stage = stage;
        jugadores = new ArrayList<>();

        stage.setTitle("Juego GPS");
        StackPane layout = new StackPane();
        Label integrantes = new Label();
        Label titulo = new Label();

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");

        //Pantalla completa
/*
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Para salir de pantalla completa, presiona ESC");
        //esta parte no funciona
        Button salirPantallaCompleta = new Button("Salir Pantalla completa");
        BotonSalirPantallaCompleta  btnSalirPantallaCompleta = new BotonSalirPantallaCompleta(this);
        salirPantallaCompleta.defaultButtonProperty().bind(salirPantallaCompleta.focusedProperty());
        salirPantallaCompleta.setOnAction( btnSalirPantallaCompleta);
*/
        //Hace algo cuando cerras la ventana
        //podria aparecer una ventana de despedida
        /*
        stage.setOnCloseRequest(e -> {
            System.out.println("cerrando pantalla");
        });
        */


        // Propiedades y setters
        comenzar.defaultButtonProperty().bind(comenzar.focusedProperty());
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        BotonSalirEvento botonSalirEvento = new BotonSalirEvento();
        salir.setOnAction(botonSalirEvento);

        BotonComenzarEvento botonComenzarEvento = new BotonComenzarEvento(this);
        comenzar.setOnAction(botonComenzarEvento);

        titulo.setText("GPS Juego - Algo3");

        integrantes.setText("Integrantes:\n" + "Cristian Martin Lin\n" + "Martin Alejo Polese\n" + "Tomas Nahuel Olivera\n" + "Jorge Sedek\n" );

        StackPane.setAlignment(titulo, Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes, Pos.BOTTOM_LEFT);

        HBox botonera = new HBox(comenzar, salir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(10);

        VBox contenedorPrincipal = new VBox(botonera);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/gpsChallenge.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout.setBackground(new Background(imagenDeFondo));

        layout.setPrefHeight(400);
        layout.setPrefWidth(500);
        layout.getChildren().addAll(contenedorPrincipal, titulo, integrantes);
        layout.setPadding(new Insets(10));

        // Stage
        stage.setScene(new Scene(layout));
        stage.centerOnScreen();
        stage.show();
    }
/*
    private void addBackground() {
        ImageView imageView = new ImageView(new Image(getClass().getResource("src/main/java/edu/fiuba/algo3/aplicacion/css/imagenes/imagen.png").toExternalForm()));
        imageView.setFitWidth(this.width);
        imageView.setFitHeight(this.height);

        root.getChildren().add(imageView);
    }

    private Parent createContent() {
        addBackground();
        return root;
    }*/

    public void salirPantallaCompleta(){
        this.stage.setFullScreen(false);
    }


    public void elegirCantidadJugadores(){
        StackPane layout = new StackPane();
        Button aceptar = new Button("Aceptar");
        Label pedirCantJugadores = new Label();

        pedirCantJugadores.setText("Seleccione la cantidad de jugadores: ");
        StackPane.setAlignment(pedirCantJugadores, Pos.TOP_CENTER);

        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().addAll(1,2,3);

        BotonAceptarEvento accept = new BotonAceptarEvento(this, choiceBox);
        aceptar.setOnAction(accept);

        StackPane.setAlignment(choiceBox, Pos.CENTER);
        StackPane.setAlignment(aceptar, Pos.CENTER);

        VBox contenedor = new VBox(pedirCantJugadores, choiceBox, aceptar);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);

        Button salir = new Button("Salir");
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        layout.getChildren().addAll(contenedor, salir);
        layout.setPadding(new Insets(10));

        StackPane.setAlignment(salir, Pos.BOTTOM_LEFT);
        layout.setPrefHeight(400);
        layout.setPrefWidth(500);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
        this.stage.centerOnScreen();
    }

/*
    public void getChoice(int cant_jugadores) {
        System.out.println(cant_jugadores);
        Random rand = new Random();
        int random = rand.nextInt(this.columna) + 1;
        System.out.println(random);
    }*/

    public void agregarJugadores(){
        StackPane layout = new StackPane();
        Label pedirNombre = new Label();
        Label pedirVehiculo = new Label();
        Label error = new Label();
        TextField nombreJugador = new TextField();
        Button siguiente = new Button("Siguiente");

        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.getItems().addAll("Moto", "Auto", "Camioneta");
        choiceBox1.setValue("Moto");

        pedirNombre.setText("Ingrese el nombre del jugador");
        pedirNombre.setAlignment(Pos.CENTER);

        pedirVehiculo.setText("Elija un vehiculo para el jugador");
        pedirVehiculo.setAlignment(Pos.CENTER);

        error.setText("");

        BotonSiguienteEvento botonSiguiente = new BotonSiguienteEvento(this, choiceBox1, nombreJugador, error, filas);
        siguiente.setOnAction(botonSiguiente);

        VBox contenedorNombre = new VBox(pedirNombre, nombreJugador);
        contenedorNombre.setAlignment(Pos.CENTER);
        contenedorNombre.setSpacing(10);

        VBox contenedorVehiculo = new VBox(pedirVehiculo, choiceBox1);
        contenedorVehiculo.setAlignment(Pos.CENTER);
        contenedorVehiculo.setSpacing(10);

        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        HBox contenedorBoton = new HBox(error, region1, siguiente);
        contenedorBoton.setSpacing(0);

        VBox contenedor = new VBox(contenedorNombre, contenedorVehiculo, contenedorBoton);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);

        layout.getChildren().add(contenedor);
        layout.setPadding(new Insets(10));

        layout.setPrefHeight(100);
        layout.setPrefWidth(500);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
        this.stage.centerOnScreen();
    }

    public void elegirTamanioEscenario(){
        StackPane layout = new StackPane();
        Label pedirFila = new Label();
        Label pedirColumna = new Label();
        Label error = new Label();
        TextField fila = new TextField();
        TextField columna = new TextField();
        Button continuar = new Button("Continuar");

        pedirFila.setText("Ingrese la cantidad de entre calles por fila");
        pedirFila.setAlignment(Pos.CENTER);
        pedirColumna.setText("Ingrese la cantidad de entre calles por columna");
        pedirColumna.setAlignment(Pos.CENTER);

        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        error.setText("");

        BotonContinuarEvento botonContinuar = new BotonContinuarEvento(this, fila, columna, error);
        continuar.setOnAction(botonContinuar);

        HBox contenedorBoton = new HBox(error, region1, continuar);
        contenedorBoton.setAlignment(Pos.CENTER);
        contenedorBoton.setSpacing(10);

        VBox contenedorDatos = new VBox(pedirFila, fila, pedirColumna, columna);
        contenedorDatos.setAlignment(Pos.CENTER);
        contenedorDatos.setSpacing(10);

        VBox contenedor = new VBox(contenedorDatos, contenedorBoton);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);

        layout.getChildren().add(contenedor);
        layout.setPadding(new Insets(10));

        layout.setPrefHeight(100);
        layout.setPrefWidth(500);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
        this.stage.centerOnScreen();
    }

    public void ingresarNombresYVehiculo(int cant_jugadores){
        this.cantidad = cant_jugadores;
        if(cant_jugadores > 0){
            agregarJugadores();
            this.cantidad --;
        }else{
            Juego.resetInstance(this.jugadores);
            this.escenarioView = new EscenarioView(this, this.stage);
            escenarioView.mostrarTablero();
            this.getStage().getScene().setOnKeyPressed(new ControladorTecladoEvento());
        }
    }
/*
    public void comenzarJuego(){
        StackPane layout = new StackPane();
        Button jugar = new Button("Jugar");

        BotonJugarEvento botonJugar = new BotonJugarEvento(this);
        jugar.setOnAction(botonJugar);

        layout.getChildren().add(jugar);
        layout.setPrefHeight(100);
        layout.setPrefWidth(100);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
    }
*/
    public void guardarJugadores(String nombre, Vehiculo vehiculo){
        Jugador jugador = new Jugador(nombre, vehiculo);
        this.jugadores.add(jugador);
        //this.probarAlgo(jugador);
        this.ingresarNombresYVehiculo(this.cantidad);
    }
/*
    public void probarAlgo(Jugador jugador){
        Ubicacion u = new Ubicacion(2,2);
        Vehiculo moto = new Moto(u);
        Vehiculo auto = new Auto(u);
        Vehiculo camion = new Camioneta(u);

        if(jugador.mismoVehiculo(moto)){
            System.out.println("SIUUU MOTO");
        }else if(jugador.mismoVehiculo(auto)){
            System.out.println("SIUUU AUTO");
        }else if(jugador.mismoVehiculo(camion)){
            System.out.println("SIUUU CAMIONETA");
        }
    }
*/
    public Stage getStage(){
        return this.stage;
    }

    public static void main(String[] args) {
        launch();
    }

    public void setFilaYColumna(int fila, int columna) {
        this.filas = 11;
        this.columnas = 11;
        Escenario.resetInstance(5,5);
        Escenario.getInstance().agregarObjetosRandom();
    }

}