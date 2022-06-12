package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public interface Sorpresa extends ObjetoUrbano {
    void recibirSorpresa(Moto moto, Jugador jugador);
    void recibirSorpresa(Camioneta camioneta, Jugador jugador);
    void recibirSorpresa(Auto auto, Jugador jugador);
}
