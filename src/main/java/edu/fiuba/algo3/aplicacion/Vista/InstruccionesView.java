package edu.fiuba.algo3.aplicacion.Vista;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.BotonCancelarSalirEvento;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstruccionesView {

    private App app;

    public InstruccionesView(App app){
        this.app = app;
    }

    public void leerInstrucciones() {
        Stage ventana = new Stage();

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
        textArea.setPrefHeight(800);
        textArea.setPrefWidth(800);

        Button salir = new Button("Atras");
        BotonCancelarSalirEvento botonSalir = new BotonCancelarSalirEvento(ventana);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        VBox vbox = new VBox(textArea, salir);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        Scene instrucciones = new Scene(vbox,1500, 1000);
        instrucciones.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        ventana.setTitle("INSTRUCCIONES");
        ventana.setScene(instrucciones);
        ventana.show();
        ventana.setAlwaysOnTop(true);
    }
}
