package edu.fiuba.algo3.modelo.General;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {
    private final List<Puntaje> PUNTUACIONES;

    private final int MAXIMOPUNTAJES = 6;

    private static Ranking INSTANCE = null;

    private Ranking() {
        this.PUNTUACIONES = new ArrayList<>();
    }

    private synchronized static void createInstance() {
        INSTANCE = new Ranking();
    }

    public static Ranking getInstance() {
        return INSTANCE;
    }

    public static void resetInstance() {
        createInstance();
    }

    public void agregarPuntaje(Puntaje puntaje) {
        this.PUNTUACIONES.add(puntaje);
        Collections.sort(PUNTUACIONES, new OrdenarPorMovimientos());

        if (this.PUNTUACIONES.size() > this.MAXIMOPUNTAJES) {
            this.PUNTUACIONES.remove(this.PUNTUACIONES.size());
        }
    }

    public void mostrar() {
        Logger.getInstance().imprimir("--------------------------------------------------------------------");
        Logger.getInstance().imprimir("Tabla de puntuaciones");
        for(Puntaje puntaje : this.PUNTUACIONES) {
            Logger.getInstance().imprimir(puntaje.obtenerNombreJugador() + ' ' + puntaje.obtenerPuntuacion());
        }
        Logger.getInstance().imprimir("¡Felicidades " + PUNTUACIONES.get(0).obtenerNombreJugador() + ", ganaste!");
    }

    public List<Puntaje> puntajes() {
        return this.PUNTUACIONES;
    }
}
