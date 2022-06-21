package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;

        stage.setTitle("Juego GPS");
        StackPane layout = new StackPane();
        Label titulo = new Label();
        Label integrantes = new Label();

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");

        comenzar.defaultButtonProperty().bind(comenzar.focusedProperty());
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        titulo.setText("GPS Juego - Algo3");
        integrantes.setText("Cristian Martin Lin" + "Martin Alejo Polese" + "Tomas Nahuel Olivera" + "Jorge Sedek" );

        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label();
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}