package edu.fiuba.algo3.modelo.General;

import java.util.Comparator;

public class OrdenarPorMovimientos implements Comparator<Puntaje> {
    @Override
    public int compare(Puntaje p1, Puntaje p2) {
        return p1.obtenerPuntuacion() - p2.obtenerPuntuacion();
    }
}
