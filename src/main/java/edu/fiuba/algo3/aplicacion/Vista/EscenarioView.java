package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.ControladorTecladoEvento;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.AutoView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.CamionetaView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.MotoView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.VehiculoView;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EscenarioView {

    private App app;
    private Stage stage;
    private double width = 1042;// Es muy grande cambiarlo a 900 o 1000
    private double height = 1042;//  Es muy grande cambiarlo a 900 o 1000
    private Group casillerosView = new Group();
    private Jugador jugador;

    private VehiculoView vehiculoView;

    public EscenarioView(App app, Stage stage){
        this.app = app;
        this.stage = stage;
    }

    public Pane mostrarTablero(){
        //BorderPane layout = new BorderPane();
        Pane layout = new Pane();
        //actualizarJugador();

        layout.getChildren().addAll(mostrarTableroView(), dibujarVehiculo());
        layout.setPrefHeight(height);
        layout.setPrefWidth(width);
        //layout.setOnKeyPressed(new ControladorTecladoEvento(jugadorActual, ));
        //layout.setOnKeyPressed(new ControladorTecladoEvento(this));

        //Scene scene = new Scene(layout);
        //scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        //stage.setScene(scene);
        //stage.getScene().setOnKeyPressed(new ControladorTecladoEvento(this));
        //stage.centerOnScreen();
        //stage.centerOnScreen();
        //stage.show();

        //VBox juego = new VBox(layout);

        return layout;
    }

    public Stage obtenerStage() {
        return this.stage;
    }

    public App obtenerApp() {
        return this.app;
    }

    public Parent mostrarTableroView(){
        int filas = Escenario.getInstance().obtenerFilas();
        int columnas = Escenario.getInstance().obtenerColumnas();

        Pane root = new Pane();

        for (int x = 1; x <= columnas; x++){
            for (int y = 1; y <= filas; y++){
                Ubicacion ubicacion = new Ubicacion(x,y);
                CasilleroView casillero = new CasilleroView(filas, columnas, this.height, this.width);
                if (ubicacion.hayCalle()) {
                    casillero.dibujarCasillero(x, y, Escenario.getInstance().buscarCasilleroEn(ubicacion), root);
                }

                if (ubicacion.hayEdificio()) {
                    EdificioView edificioView = new EdificioView(x, y, height, width, filas, columnas);
                    root.getChildren().add(edificioView);

                }

                casillerosView.getChildren().add(casillero);
            }
        }
        actualizarJugador();

        return root;

    }

    public void actualizarJugador(){
        this.jugador = Juego.getInstance().obtenerJugadorActivo();
    }

    public Parent dibujarVehiculo(){
       int filas = Escenario.getInstance().obtenerFilas();
       int columnas = Escenario.getInstance().obtenerColumnas();

       double alto = width/(double)filas;
       double ancho = height/(double)columnas;

       //Borre la imagen en la posicion anterior y agrege un boton para siguiente
       //boton siguiente llama a mostrarTablero();

       Pane root = new Pane();

       // Quiza quitar este if
       if (jugador == null) {
           return root;
       }

       Vehiculo vehiculo =  jugador.obtenerVehiculo();
       if (vehiculo instanceof Auto ){
           AutoView autoView4 = new AutoView((Auto) vehiculo,root,alto,ancho);
           autoView4.dibujar();
       }

       if (vehiculo instanceof Moto) {
           MotoView motoView4 = new MotoView((Moto) vehiculo, root,alto,ancho);
           motoView4.dibujar();
       }

       if (vehiculo instanceof Camioneta){

           CamionetaView camionetaView4 = new CamionetaView((Camioneta) vehiculo, root, alto, ancho);
         //  camionetaView4.posicionarImagen();
           camionetaView4.dibujar();
        //   camionetaView4.mover();
       }
/*
        int filas = Escenario.getInstance().obtenerFilas();
        int columnas = Escenario.getInstance().obtenerColumnas();

        double alto = width/(double)filas;
        double ancho = height/(double)columnas;

        Vehiculo vehiculo =  jugador.obtenerVehiculo();
        if (vehiculo instanceof Auto ){
            AutoView autoView4 = new AutoView((Auto) vehiculo,root, alto, ancho);
            autoView4.dibujar();
        }

        if (vehiculo instanceof Moto) {
            MotoView motoView4 = new MotoView((Moto) vehiculo, root, alto, ancho);
            motoView4.dibujar();
        }

        else{
            CamionetaView camionetaView4 = new CamionetaView((Camioneta) vehiculo, root, alto, ancho);
            camionetaView4.dibujar();
        }
*/

       return root;

    }


    public void actualizar(){
        mostrarTablero();
        //dibujarVehiculo();
    }

}

/*
    Del modelo.

    public Casillero buscarCasilleroEn(Ubicacion ubicacion){
        List<Casillero> casillerosFiltrados = casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)).collect(Collectors.toList());
        return casillerosFiltrados.get(0);
    }
    */