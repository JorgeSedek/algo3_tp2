package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public interface Sorpresa extends ObjetoUrbano {
    void recibirSorpresa(Jugador jugador, Moto moto);
    void recibirSorpresa(Jugador jugador, Camioneta camioneta);
    void recibirSorpresa(Jugador jugador, Auto auto);
}
