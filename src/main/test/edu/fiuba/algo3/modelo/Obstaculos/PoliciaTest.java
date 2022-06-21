package edu.fiuba.algo3.modelo.Obstaculos;

//FALTA IMPLEMENTAR TESTS

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
//import static org.mockito.stubbing.Answer;

/*
public class PoliciaTest{
    private String nombre = "SinNombre";
    private int fila = 1;
    private int col = 1;

    @Mock
    Moto moto;
    Auto auto;
    Camioneta camioneta;


    @InjectMocks
    Jugador jugador;

    @Test
    public void MotoPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = mock(Policia.class);
        int cantidadMovimientos = 3;

        doAnswer(invocation -> {


            return null;
        }).when(moto).atravesar(policia);

        moto.atravesar(policia);

        verify(moto).atravesar(policia);
        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }
}

*/