package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Favorable implements Sorpresa {

    public void recibirSorpresa(Vehiculo vehiculo, Jugador jugador) {
        int movimientosReducidos = jugador.movimientos() / 5;
        jugador.disminuirMovimientos(movimientosReducidos);
    }
}
