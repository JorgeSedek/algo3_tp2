package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void seCreaCorrectamenteLaClaseJugador(){
        String nombre = "Pablo";
        Jugador jugador = new Jugador(nombre,new Auto(new Ubicacion(1,1), new MovimientoNormal()));
        assertEquals(jugador.obtenerNombre(),nombre);
        assertEquals(jugador.movimientos(),0);
    }

    @Test
    public void seAumentaCorrectamenteElPuntaje(){
        int incremento = 3;
        Jugador jugador = new Jugador("Pablo", new Auto(new Ubicacion(1,1), new MovimientoNormal()));
        jugador.incrementarMovimientos(incremento);
        assertEquals(jugador.movimientos(), incremento);
    }

    @Test
    public void seReduceCorrectamenteElPuntaje(){
        int reducir = 3;
        Jugador jugador = new Jugador("Pablo", new Auto(new Ubicacion(1,1), new MovimientoNormal()));
        jugador.disminuirMovimientos(reducir);
        assertEquals(jugador.movimientos(),-3);
    }
}
