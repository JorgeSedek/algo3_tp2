package edu.fiuba.algo3.modelo.Obstaculos;

/*
//FALTA IMPLEMENTAR TESTS
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.Math.Random;
import org.junit.jupiter.api.Test;
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
    private double randomFalso = 0.2;
    //@Mock
    //private Random random;
    //private Policia policia;
    @Test
    public void MotoPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        IMath random = mock(IMath.class);
        //doNothing().when(random.darNumeroAleatorio());
        when(random.darNumeroAleatorio()).thenReturn(randomFalso);
        moto.atravesar(policia);
        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }
    @Test
    public void AutoPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        IMath random = mock(Random.class);
        //doNothing().when(random.darNumeroAleatorio());
        when(random.darNumeroAleatorio()).thenReturn(randomFalso);
        auto.atravesar(policia);
        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }
    @Test
    public void CamionetaPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        IMath random = mock(Random.class);
        //doNothing().when(random.darNumeroAleatorio());
        when(random.darNumeroAleatorio()).thenReturn(randomFalso);
        camioneta.atravesar(policia);
        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }

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
    @Test
    public void CamionetaPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        Obstaculo policiaSpy = Mockito.spy(policia);
        doAnswer((policiaP)->{
            Policia poli = (Policia)policiaP.getMock();
            Efecto efecto = new EfectoGeneral();
            return new EfectoIncrementarMovimientos(efecto, cantidadMovimientos);
            //return null;
        }).when(policiaSpy).atravesar((Camioneta) camioneta);
        camioneta.atravesar(policia);
        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }
    @Test
    public void AutoPasaPorPoliciaYSeLeSuma3Movimientos(){
        Obstaculo policia = new Policia();
        Ubicacion ubicacion = (new Ubicacion(fila, col));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        Obstaculo policiaSpy = Mockito.spy(policia);
        doAnswer((policiaP)->{
            Policia poli = (Policia)policiaP.getMock();
            Efecto efecto = new EfectoGeneral();
            return new EfectoIncrementarMovimientos(efecto, cantidadMovimientos);
            //return null;
        }).when(policiaSpy).atravesar((Auto) auto);
        auto.atravesar(policia);
        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }
}
*/