package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class EscenarioView {

    private App app;
    private Stage stage;
    private double width = 1000;// Es muy grande cambiarlo a 900 o 1000
    private double height = 1000;//  Es muy grande cambiarlo a 900 o 1000
    private int filas = 11;
    private int columnas = 11;
    private Group casillerosView = new Group();
    private Escenario escenario;

    public EscenarioView(App app, Escenario escenario, Stage stage){
        this.app = app;
        this.escenario = escenario;
        this.stage = stage;
    }

    public void mostrarTablero(){
        StackPane layout = new StackPane();
        layout.getChildren().addAll(mostrarTableroView());
        layout.setPrefHeight(height);
        layout.setPrefWidth(width);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public Parent mostrarTableroView(){
        int filas = this.filas;
        int columnas = this.columnas;

        Pane root = new Pane();

        for (int x = 1; x <= filas; x++) {
            for (int y = 1; y <= columnas; y++) {
                Ubicacion ubicacion = new Ubicacion(x,y);
                CasilleroView casillero = new CasilleroView(this.filas, this.columnas, this.height, this.width);
                if (ubicacion.hayCalle()) {
                    casillero.dibujarCasillero(x, y, Escenario.getInstance().buscarCasilleroEn(ubicacion), root);
                }

                //Escenario.getInstance().agregarObstaculoEn(new U);
                if (ubicacion.hayEdificio()) {
                    EdificioView edificioView = new EdificioView(x, y, height, width, filas, columnas);
                    root.getChildren().add(edificioView);

                }

                casillerosView.getChildren().add(casillero);
            }
        }

        return root;
    }


}

/*
    Del modelo.

    public Casillero buscarCasilleroEn(Ubicacion ubicacion){
        List<Casillero> casillerosFiltrados = casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)).collect(Collectors.toList());
        return casillerosFiltrados.get(0);
    }
    */