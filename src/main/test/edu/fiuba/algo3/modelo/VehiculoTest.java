package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {
    private int fila = 1;
    private int columna = 1;

    @Test
    public void unAutoSeMueveEnDistintasDireccionesDeberiaEstarEnLaUbicacionCorrecta(){
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo auto = new Auto(casillero);

        auto.mover(new DireccionDerecha());
        int nuevaFila = 1;
        int nuevaColumna = 2;
        Casillero nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(auto.verificarCasillero(nuevoCasillero));

        auto.mover(new DireccionIzquierda());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(auto.verificarCasillero(nuevoCasillero));

        auto.mover(new DireccionAbajo());
        nuevaFila = 2;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(auto.verificarCasillero(nuevoCasillero));

        auto.mover(new DireccionArriba());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(auto.verificarCasillero(nuevoCasillero));
    }

    @Test
    public void unaMotoSeMueveEnDistintasDireccionesDeberiaEstarEnLaUbicacionCorrecta(){
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo moto = new Moto(casillero);

        moto.mover(new DireccionDerecha());
        int nuevaFila = 1;
        int nuevaColumna = 2;
        Casillero nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(moto.verificarCasillero(nuevoCasillero));

        moto.mover(new DireccionIzquierda());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(moto.verificarCasillero(nuevoCasillero));

        moto.mover(new DireccionAbajo());
        nuevaFila = 2;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(moto.verificarCasillero(nuevoCasillero));

        moto.mover(new DireccionArriba());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(moto.verificarCasillero(nuevoCasillero));
    }

    @Test
    public void unaCamionetaSeMueveEnDistintasDireccionesDeberiaEstarEnLaUbicacionCorrecta(){
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo camioneta = new Camioneta(casillero);

        camioneta.mover(new DireccionDerecha());
        int nuevaFila = 1;
        int nuevaColumna = 2;
        Casillero nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(camioneta.verificarCasillero(nuevoCasillero));

        camioneta.mover(new DireccionIzquierda());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(camioneta.verificarCasillero(nuevoCasillero));

        camioneta.mover(new DireccionAbajo());
        nuevaFila = 2;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(camioneta.verificarCasillero(nuevoCasillero));

        camioneta.mover(new DireccionArriba());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoCasillero = new Casillero(nuevaFila, nuevaColumna);
        assertTrue(camioneta.verificarCasillero(nuevoCasillero));
    }
}
