package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.SinObstaculo;
import edu.fiuba.algo3.modelo.Ocupante.Edificio;
import edu.fiuba.algo3.modelo.Ocupante.Ocupante;
import edu.fiuba.algo3.modelo.Ocupante.Vacio;
import edu.fiuba.algo3.modelo.Sorpresas.SinSorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Casillero {
    private Vehiculo vehiculo;
    private Ocupante ocupante;
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;
    private Ubicacion ubicacion;

    public Casillero(int fila, int columna) {
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
