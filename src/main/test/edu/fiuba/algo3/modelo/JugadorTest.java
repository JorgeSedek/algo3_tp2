package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void seCreaCorrectamenteLaClaseJugador(){
        Jugador jugador = new Jugador("Pablo",new Auto(new Ubicacion(1,1), new MovimientoNormal()));
        assertEquals(jugador.obtenerNombre(),"Pablo");
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

    @Test
    public void movimientoCorrectoDevuelveResutadoCorrecto(){
        int cantMovimientos = 2;
        Jugador jugador = new Jugador("Cr", new Auto(new Ubicacion(1,1), new MovimientoNormal()));
        jugador.incrementarMovimientos(2);
        assertTrue(jugador.verificarMovimiento(2));
    }

    @Test
    public void movimientoIncorrectoDevuelveResutadoCorrecto(){
        int cantMovimientos = 2;
        Jugador jugador = new Jugador("Cr", new Auto(new Ubicacion(1,1), new MovimientoNormal()));
        jugador.incrementarMovimientos(2);
        assertFalse(jugador.verificarMovimiento(3));
    }
}
