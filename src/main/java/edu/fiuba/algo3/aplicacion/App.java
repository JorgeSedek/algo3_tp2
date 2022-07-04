package edu.fiuba.algo3.aplicacion;

import edu.fiuba.algo3.aplicacion.Eventos.*;

import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.AutoView;

import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.ObstaculosView.PiqueteView;
import edu.fiuba.algo3.modelo.General.*;

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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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

    private Escenario escenario;
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
        Button instrucciones = new Button("Instrucciones");

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
        instrucciones.defaultButtonProperty().bind(instrucciones.focusedProperty());

        BotonSalirEvento botonSalirEvento = new BotonSalirEvento();
        salir.setOnAction(botonSalirEvento);

        BotonComenzarEvento botonComenzarEvento = new BotonComenzarEvento(this);
        comenzar.setOnAction(botonComenzarEvento);

        BotonInstruccionesEvento botonInstruccionesEvento = new BotonInstruccionesEvento(this);
        instrucciones.setOnAction(botonInstruccionesEvento);

        titulo.setText("GPS Juego - Algo3");

        integrantes.setText("Integrantes:\n" + "Cristian Martin Lin\n" + "Martin Alejo Polese\n" + "Tomas Nahuel Olivera\n" + "Jorge Sedek\n" );

        StackPane.setAlignment(titulo, Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes, Pos.BOTTOM_LEFT);

        HBox botonera = new HBox(comenzar, instrucciones, salir);
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
        Image icon = new Image("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/icon.png");
        stage.getIcons().add(icon);
        stage.setScene(new Scene(layout));
        //stage.setResizable(false);
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


/*
    public void getChoice(int cant_jugadores) {
        System.out.println(cant_jugadores);
        Random rand = new Random();
        int random = rand.nextInt(this.columna) + 1;
        System.out.println(random);
    }*/
/*
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

        BotonMotoEvento botonMotoEvento = new BotonMotoEvento(this, nombreJugador, error, );
        moto.setOnAction(botonMotoEvento);

        BotonAutoEvento botonAutoEvento = new BotonAutoEvento(this, nombreJugador, error, );
        auto.setOnAction(botonAutoEvento);

        BotonCamionetaEvento botonCamionetaEvento = new BotonCamionetaEvento(this, nombreJugador, error);
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
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this);
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

        layout.setPrefHeight(100);
        layout.setPrefWidth(500);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
        this.stage.centerOnScreen();
    }
*/
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
        this.getStage().setResizable(false);
        this.getStage().centerOnScreen();
        this.getStage().setScene(scene);


    }

    /*
    public void elegirTamanioEscenario(){
        StackPane layout = new StackPane();
        Label pedirTamanio = new Label();
        Button Grande = new Button("Grande");
        Button Chico = new Button("Chico");


        pedirTamanio.setText("Elija la medida del escenario");
        pedirTamanio.setAlignment(Pos.CENTER);

        BotonEscenarioGrandeEvento botonEscenarioGrandeEvento = new BotonEscenarioGrandeEvento(this);
        Grande.setOnAction(botonEscenarioGrandeEvento);

        BotonEscenarioChicoEvento botonEscenarioChicoEvento = new BotonEscenarioChicoEvento(this);
        Chico.setOnAction(botonEscenarioChicoEvento);

        HBox contenedorBoton = new HBox(Chico, Grande);
        contenedorBoton.setAlignment(Pos.CENTER);
        contenedorBoton.setSpacing(10);

        VBox contenedor = new VBox(pedirTamanio, contenedorBoton);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);

        Button salir = new Button("Salir");
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        layout.getChildren().addAll(contenedor, salir);
        layout.setPadding(new Insets(10));
        layout.setPrefHeight(200);
        layout.setPrefWidth(400);
        StackPane.setAlignment(salir, Pos.BOTTOM_LEFT);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
        this.stage.centerOnScreen();
    }
    */
/*
    public void ingresarNombresYVehiculo(int cant_jugadores){

        this.cantidad = cant_jugadores;
        if(cant_jugadores > 0){
            agregarJugadores();
            this.cantidad --;
        }else{
            Juego.resetInstance(this.jugadores);
            this.escenarioView = new EscenarioView(this, this.stage);

            escenarioView.mostrarTablero();
        }
    }

 */
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
    /*
    public void guardarJugadores(String nombre, Vehiculo vehiculo){
        Jugador jugador = new Jugador(nombre, vehiculo);
        this.jugadores.add(jugador);
        //this.probarAlgo(jugador);
        this.ingresarNombresYVehiculo(this.cantidad);
    }

     */
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