package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.ControladorTecladoEvento;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.AutoView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.CamionetaView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.CreadorVehiculosView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.MotoView;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class EscenarioView {

    private App app;
    private Stage stage;
    private double width = 700;// Es muy grande cambiarlo a 900 o 1000
    private double height = 700;//  Es muy grande cambiarlo a 900 o 1000
    private Group casillerosView = new Group();
    private Jugador jugador;

    public EscenarioView(App app, Stage stage){
        this.app = app;
        this.stage = stage;
    }

    public void mostrarTablero(){
        BorderPane layout = new BorderPane();
        //actualizarJugador();

        layout.getChildren().addAll(mostrarTableroView(), dibujarVehiculo());
        layout.setPrefHeight(height);
        layout.setPrefWidth(width);
        //layout.setOnKeyPressed(new ControladorTecladoEvento(jugadorActual, ));
        //layout.setOnKeyPressed(new ControladorTecladoEvento(this));

        stage.setScene(new Scene(layout));
        stage.getScene().setOnKeyPressed(new ControladorTecladoEvento(this));
        //stage.centerOnScreen();
        stage.show();
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
/*
        Auto auto = new Auto(new Ubicacion(2,2));

        Moto moto = new Moto(new Ubicacion(4,2));
        Camioneta camioneta = new Camioneta(new Ubicacion(2,2));
        Camioneta camioneta2 = new Camioneta(new Ubicacion(4,2));
        AutoView autoView = new AutoView(auto,root);
        MotoView motoView = new MotoView(moto,root);
        CamionetaView camionetaView = new CamionetaView(camioneta,root);
        CamionetaView camionetaView2 = new CamionetaView(camioneta2,root);
*/
/*
       Vehiculo vehiculo =  jugador.obtenerVehiculo();
        if (vehiculo instanceof Auto ){
            AutoView autoView3 = new AutoView((Auto) vehiculo,root);
            autoView3.dibujar();
        }

        if (vehiculo instanceof Moto) {
            MotoView motoView3 = new MotoView((Moto) vehiculo, root);
            motoView3.dibujar();
        }

        if (vehiculo instanceof Camioneta){
            CamionetaView camionetaView3 = new CamionetaView((Camioneta) vehiculo, root);
            camionetaView3.dibujar();
        }
        */

            //Moto moto = new Moto(new Ubicacion(4,2));
        //Camioneta camioneta = new Camioneta(new Ubicacion(2,4));
        //MotoView motoView = new MotoView(moto,root);
        //CamionetaView camionetaView = new CamionetaView(camioneta,root);


       // autoView.dibujar();
      //  camionetaView.dibujar();
    //    camionetaView2.dibujar();
       // motoView.dibujar();


        /*
        CreadorVehiculosView creador = new CreadorVehiculosView();

        creador.crear(auto, root);
        creador.crear(moto, root);
        creador.crear(camioneta, root);
*/
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
           camionetaView4.dibujar();
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