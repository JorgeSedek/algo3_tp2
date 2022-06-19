package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Ocupante.Edificio;
import edu.fiuba.algo3.modelo.Ocupante.Ocupante;
import edu.fiuba.algo3.modelo.Ocupante.Vacio;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Casillero {
    private int fila;
    private int columna;
    private Vehiculo vehiculo;
    private Ocupante ocupante;

    private Ubicacion ubicacion;

    public Casillero(int fila, int columna) {
        this.ubicacion = new Ubicacion(fila,columna);
        this.ocupante = (Ocupante) new Vacio();
        if (this.hayEdificio()){
            this.ocupante = (Ocupante) new Edificio();
        }
    }

    public boolean hayEdificio(){
        return (ubicacion.hayEdificio());
    }
    public void colocar(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }



}
