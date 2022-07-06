package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoTest {
    private int fila = 1;
    private int columna = 1;

    @Test
    public void unAutoSeMueveEnDistintasDireccionesDeberiaEstarEnLaUbicacionCorrecta(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion);

        auto.mover(new DireccionDerecha());
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(auto.verificarUbicacion(nuevoUbicacion));

        auto.mover(new DireccionIzquierda());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(auto.verificarUbicacion(nuevoUbicacion));

        auto.mover(new DireccionAbajo());
        nuevaFila = 3;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(auto.verificarUbicacion(nuevoUbicacion));

        auto.mover(new DireccionArriba());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(auto.verificarUbicacion(nuevoUbicacion));
    }

    @Test
    public void unaMotoSeMueveEnDistintasDireccionesDeberiaEstarEnLaUbicacionCorrecta(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);

        moto.mover(new DireccionDerecha());
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));

        moto.mover(new DireccionIzquierda());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));

        moto.mover(new DireccionAbajo());
        nuevaFila = 3;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));

        moto.mover(new DireccionArriba());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
    }

    @Test
    public void unaCamionetaSeMueveEnDistintasDireccionesDeberiaEstarEnLaUbicacionCorrecta(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(ubicacion);

        camioneta.mover(new DireccionDerecha());
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));

        camioneta.mover(new DireccionIzquierda());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));

        camioneta.mover(new DireccionAbajo());
        nuevaFila = 3;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));

        camioneta.mover(new DireccionArriba());
        nuevaFila = 1;
        nuevaColumna = 1;
        nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));
    }
}
