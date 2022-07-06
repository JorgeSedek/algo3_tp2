package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.AutoView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.CamionetaView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.MotoView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.VehiculoView;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Meta.MetaFinal;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class EscenarioView {

    private App app;
    private Stage stage;
    private double width = 1042;
    private double height = 1042;
    private Group casillerosView = new Group();
    private Jugador jugador;
    private Casillero meta;

    private VehiculoView vehiculoView;

    public EscenarioView(App app, Stage stage){
        this.app = app;
        this.stage = stage;
    }

    public Pane mostrarTablero(){

        Pane layout = new Pane();

        if(Juego.getInstance().hayJugadoresActivos()){
            layout.getChildren().addAll(mostrarTableroView(), dibujarVehiculo(), dibujarCirculoRojo());
        }else{
            layout.getChildren().addAll(mostrarTableroView(), dibujarVehiculo());
        }

        layout.setPrefHeight(height);
        layout.setPrefWidth(width);
        layout.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");

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

       Pane root = new Pane();

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
           camionetaView4.dibujar();

       }

       return root;

    }


    public void actualizar(){
        mostrarTablero();
    }

    public Parent dibujarCirculoRojo(){
        Pane root = new Pane();
        StackPane layout = new StackPane();

        double radioMeta = width/(double)Escenario.getInstance().obtenerFilas();
        double radioVehiculo = radioMeta *2;

        Vehiculo vehiculo = jugador.obtenerVehiculo();

        double filaVehiculo = ((double)vehiculo.obtenerUbicacion().obtenerFila()- 2) * radioMeta+ radioMeta*1.3;
        double columnaVehiculo = ((double)vehiculo.obtenerUbicacion().obtenerColumna()- 2) * radioMeta+ radioMeta*1.3 ;

        Circle vehiculoCircle = new Circle(columnaVehiculo, filaVehiculo, radioVehiculo, Color.TRANSPARENT);

        this.meta = buscarMeta();
        double filaMeta = ((double)this.meta.obtenerUbicacion().obtenerFila()- 2) * radioMeta + radioMeta*1.2;
        double columnaMeta = ((double)this.meta.obtenerUbicacion().obtenerColumna()- 2) * radioMeta + radioMeta*1.2;

        Circle meta = new Circle(columnaMeta, filaMeta, radioMeta, Color.TRANSPARENT);

        Rectangle rectanglea = new Rectangle(width, height, Color.BLACK);
        Shape algo = Shape.subtract(rectanglea, vehiculoCircle);
        algo = Shape.subtract(algo, meta);

        layout.getChildren().addAll(algo);
        root.getChildren().add(layout);
        return root;
    }

    public Casillero buscarMeta(){

        Casillero metaFinal = new Casillero(0,0);

        int filas = Escenario.getInstance().obtenerFilas();
        int columnas = Escenario.getInstance().obtenerColumnas();

        for (int x = 1; x <= columnas; x++) {
            for (int y = 1; y <= filas; y++) {
                Ubicacion ubicacion = new Ubicacion(x,y);
                if(Escenario.getInstance().buscarCasilleroEn(ubicacion).obtenerMeta() instanceof MetaFinal){
                    metaFinal =  Escenario.getInstance().buscarCasilleroEn(ubicacion);
                }
            }
        }


        return metaFinal;
    }

}
