package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public interface Efecto {
    void aplicar(Vehiculo vehiculo);
    void aplicar(Jugador jugador);
}
