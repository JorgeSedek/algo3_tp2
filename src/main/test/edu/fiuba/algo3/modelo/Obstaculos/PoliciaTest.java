package edu.fiuba.algo3.modelo.Obstaculos;

//FALTA IMPLEMENTAR TESTS

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
//import edu.fiuba.algo3.modelo.General.Random;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
//import edu.fiuba.algo3.modelo.General.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
//import static org.mockito.stubbing.Answer;


public class PoliciaTest{
    private String nombre = "SinNombre";
    private int fila = 1;
    private int col = 1;
    private int cantidadMovimientos = 3;

    //@Mock
    //private Random random;
    //private Policia policia;

/*    @Test
    public void MotoPasaPorPoliciaYSeLeSuma3Movimientos(){
        //Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        //Efecto efecto = new EfectoGeneral();
        double probabilidadParo = 0.8;

        //when(policia.calcularEfecto(probabilidadParo)).thenAnswer(new EfectoIncrementarMovimientos(efecto, cantidadMovimientos));
        //when(policia.atravesar(moto)).thenAnswer(new EfectoIncrementarMovimientos(efecto, cantidadMovimientos));

        doAnswer((policiaP) -> {
            Efecto efecto = new EfectoGeneral().getMock();
            Efecto efectoIncrementar = new EfectoIncrementarMovimiento(efecto, cantidadMovimientos).getMock();
            policia.efectoIncrementar;
            return null;
        })

        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }*/

    @Test
    public void MotoPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        Obstaculo policiaSpy = Mockito.spy(policia);

        doAnswer((policiaP)->{
            Policia poli = (Policia)policiaP.getMock();
            Efecto efecto = new EfectoGeneral();
            return new EfectoIncrementarMovimientos(efecto, cantidadMovimientos);

            //return null;
        }).when(policiaSpy).atravesar((Moto) moto);

        moto.atravesar(policia);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));

    }

}

/*
    doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {

            Efecto efecto = new EfectoGeneral();
            new EfectoIncrementarMovimientos(efecto, cantidadMovimientos);

            return null;
        }
    }).when(policia.atravesar((Moto)moto));


    when(policia.calcularEfecto(probabilidadParo, 0.5)).thenAnswer(new Answer<Efecto>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Efecto efecto = new EfectoGeneral();
                return new EfectoIncrementarMovimientos(efecto, cantidadMovimientos);
            }
        });
    */
