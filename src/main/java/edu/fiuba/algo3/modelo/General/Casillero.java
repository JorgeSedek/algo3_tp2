package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Meta.SinMeta;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.SinObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.SinSorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Casillero {
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;
    private Meta meta;
    private Ubicacion ubicacion;

    public Casillero(int fila, int columna) {
        this.ubicacion = new Ubicacion(fila,columna);
        this.obstaculo = new SinObstaculo();
        this.sorpresa = new SinSorpresa();
        this.meta = new SinMeta();
    }

    public void asignarObstaculo(Obstaculo obstaculo){
        this.obstaculo = obstaculo;
    }

    public void asignarSorpresa(Sorpresa sorpresa){
        this.sorpresa = sorpresa;
    }

    public Ubicacion obtenerUbicacion(){
        return this.ubicacion;
    }

    public boolean equals(Casillero otroCasillero){
        return (this.ubicacion.equals(otroCasillero.obtenerUbicacion()));
    }

    public boolean equals(Ubicacion otraUbicacion) {
        return (this.ubicacion.equals(otraUbicacion));
    }

    public Efecto atravesar(Vehiculo vehiculo) {
        Efecto efecto = new EfectoGeneral();
        efecto = vehiculo.atravesar(sorpresa, efecto);
        efecto = vehiculo.atravesar(obstaculo, efecto);
        efecto = vehiculo.atravesar(meta, efecto);

        return efecto;
    }
}
