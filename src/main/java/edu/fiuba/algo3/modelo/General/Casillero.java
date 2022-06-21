package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.SinObstaculo;
import edu.fiuba.algo3.modelo.Ocupante.Edificio;
import edu.fiuba.algo3.modelo.Ocupante.Ocupante;
import edu.fiuba.algo3.modelo.Ocupante.Vacio;
import edu.fiuba.algo3.modelo.Sorpresas.SinSorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

import java.util.HashMap;

public class Casillero {
    private Vehiculo vehiculo;
    private Ocupante ocupante;
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;
    private Ubicacion ubicacion;

    private HashMap<Direccion, Casillero> casillerosAdyacentes;

    public Casillero(int fila, int columna) {
        this.casillerosAdyacentes = new HashMap<Direccion, Casillero>();
        this.ubicacion = new Ubicacion(fila,columna);
        this.obstaculo = new SinObstaculo();
        this.sorpresa = new SinSorpresa();
        this.ocupante = (Ocupante) new Vacio();
        if (this.hayEdificio()){
            this.ocupante = (Ocupante) new Edificio();
        }
    }

    public Casillero(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.ocupante = (Ocupante) new Vacio();
    }

    public void cargarCasillerosAdyacentes(){

        Escenario escenario = Escenario.getInstance();

        Ubicacion ubicacionDerecha = ubicacion.copia();
        ubicacionDerecha.mover(new DireccionDerecha());
        Casillero casilleroDerecha = escenario.buscarCasilleroEn(ubicacionDerecha);
        casillerosAdyacentes.put(new DireccionDerecha(), casilleroDerecha);

        Ubicacion ubicacionIzquierda = ubicacion.copia();
        ubicacionIzquierda.mover(new DireccionIzquierda());
        Casillero casilleroIzquierda = escenario.buscarCasilleroEn(ubicacionIzquierda);
        casillerosAdyacentes.put(new DireccionIzquierda(), casilleroIzquierda);

        Ubicacion ubicacionArriba = ubicacion.copia();
        ubicacionArriba.mover(new DireccionArriba());
        Casillero casilleroAbajo = escenario.buscarCasilleroEn(ubicacionArriba);
       casillerosAdyacentes.put(new DireccionAbajo(), casilleroAbajo);


        Ubicacion ubicacionAbajo = ubicacion.copia();
        ubicacionAbajo.mover(new DireccionAbajo());
        Casillero casilleroArriba = escenario.buscarCasilleroEn(ubicacionAbajo);
        casillerosAdyacentes.put(new DireccionArriba(), casilleroArriba);
    }

    public boolean verificarCasillerosAdyacentes(HashMap<Direccion, Casillero> casillerosAdyacentes){
        DireccionDerecha derecha = new DireccionDerecha();
        DireccionIzquierda izquierda = new DireccionIzquierda();
        DireccionArriba arriba = new DireccionArriba();
        DireccionAbajo abajo = new DireccionAbajo();
        /*
        boolean casilleroDerechaEsIgual = (casillerosAdyacentes.get(derecha)).equals(this.casillerosAdyacentes.get(derecha));
        boolean casilleroIzquierdaEsIgual = (casillerosAdyacentes.get(izquierda)).equals(this.casillerosAdyacentes.get(izquierda));
        boolean casilleroArribaEsIgual = (casillerosAdyacentes.get(arriba)).equals(this.casillerosAdyacentes.get(arriba));
        boolean casilleroAbajoEsIgual = (casillerosAdyacentes.get(abajo)).equals(this.casillerosAdyacentes.get(abajo));
*/
        return (true /*casilleroAbajoEsIgual & casilleroArribaEsIgual & casilleroIzquierdaEsIgual & casilleroDerechaEsIgual*/);
    }

    public boolean hayEdificio(){
        return (ubicacion.hayEdificio());
    }
    public void colocar(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    public void entregaSorpresa(Vehiculo vehiculo){
        vehiculo.atravesar(sorpresa);
    }

    public void entregaObstaculo(Vehiculo vehiculo){
        vehiculo.atravesar(obstaculo);
    }

    public void asignarSorpresa(Sorpresa sorpresa){
        this.sorpresa = sorpresa;
    }

    public void asignarObstaculo(Obstaculo obstaculo){
        this.obstaculo = obstaculo;
    }

    public Ubicacion ubicacion(){
        return this.ubicacion;
    }
    public boolean equals(Casillero otroCasillero){
        return (this.ubicacion.equals(otroCasillero.ubicacion()));
    }

    public boolean equals(Ubicacion otraUbicacion) {
        return (this.ubicacion.equals(otraUbicacion));
    }
}
