package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.List;
import java.util.stream.Collectors;
/*
public class EscenarioView {

    private App app;
    private double width = 1100;
    private double height = 1100;
    private int filas = 11;
    private int columnas = 11;
    private Group casillerosView = new Group();
    private Escenario escenario;

    public EscenarioView(App app, Escenario escenario){
        this.app = app;
        this.escenario = escenario;
    }

    public void mostrarTablero(){
        StackPane layout = new StackPane();
        layout.getChildren().addAll(mostrarTableroView());

        this.app.getStage().setScene(new Scene(layout));
        this.app.getStage().show();
    }

    public Parent mostrarTableroView(){
        int filas = this.filas;
        int columnas = this.columnas;
        CasilleroView casillero = new CasilleroView(this.filas, this.columnas, this.height, this.width);

        Pane root = new Pane();

        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                Ubicacion ubicacion = new Ubicacion(x,y);
                casillero.dibujarCasillero(x, y, this.escenario.buscarCasilleroEn(ubicacion));

                casillerosView.getChildren().add(casillero);

            }
        }

        return root;
    }


}
*/
/*
    Del modelo.

    public Casillero buscarCasilleroEn(Ubicacion ubicacion){
        List<Casillero> casillerosFiltrados = casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)).collect(Collectors.toList());
        return casillerosFiltrados.get(0);
    }
    */