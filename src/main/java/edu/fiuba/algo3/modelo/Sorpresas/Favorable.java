package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Favorable implements Sorpresa {
    @Override
    public void recibirSorpresa(Moto moto, Jugador jugador) {
        double reduccionPuntaje = jugador.movimientos() * 0.2;
        jugador.disminuirMovimientos((int) reduccionPuntaje);
    }

    @Override
    public void recibirSorpresa(Camioneta camioneta, Jugador jugador) {
        double reduccionPuntaje = jugador.movimientos() * 0.2;
        jugador.disminuirMovimientos((int) reduccionPuntaje);
    }

    @Override
    public void recibirSorpresa(Auto auto, Jugador jugador) {
        double reduccionPuntaje = jugador.movimientos() * 0.2;
        jugador.disminuirMovimientos((int) reduccionPuntaje);
    }
}
