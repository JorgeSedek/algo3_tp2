package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Desfavorable implements Sorpresa {
    @Override
    public void recibirSorpresa(Moto moto, Jugador jugador) {
        double aumentoPuntaje = jugador.movimientos() * 0.2;
        jugador.incrementarMovimientos((int) aumentoPuntaje);
    }

    @Override
    public void recibirSorpresa(Camioneta camioneta, Jugador jugador) {
        double aumentoPuntaje = jugador.movimientos() * 0.2;
        jugador.incrementarMovimientos((int) aumentoPuntaje);
    }

    @Override
    public void recibirSorpresa(Auto auto, Jugador jugador) {
        double aumentoPuntaje = jugador.movimientos() * 0.2;
        jugador.incrementarMovimientos((int) aumentoPuntaje);
    }
}
