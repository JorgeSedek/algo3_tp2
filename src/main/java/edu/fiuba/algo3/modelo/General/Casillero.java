package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Meta.SinMeta;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.SinObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.SinSorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Casillero {
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;
    private Meta meta;
    private final Ubicacion UBICACION;

    public Casillero(int fila, int columna) {
        this.UBICACION = new Ubicacion(fila,columna);
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

    public void asignarMeta(Meta meta) {
        this.meta = meta;
    }

    public boolean equals(Casillero otroCasillero){
        return (otroCasillero.equals(this.UBICACION));
    }

    public boolean equals(Ubicacion otraUbicacion) {
        return (this.UBICACION.equals(otraUbicacion));
    }

    public void atravesar(Jugador jugador) {
        jugador.atravezar(sorpresa);
        jugador.atravezar(obstaculo);
        jugador.atravezar(meta);
    }

    public boolean podesTenerMeta() {
        return this.UBICACION.podesTenerMeta();
    }

    public boolean hayCalle() {
        return this.UBICACION.hayCalle();
    }

    public Obstaculo obtenerObstaculo(){
        return this.obstaculo;
    }

    public Sorpresa obtenerSorpresa(){
        return this.sorpresa;
    }

    public Ubicacion obtenerUbicacion(){
        return this.UBICACION;
    }
}
