package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

import java.util.ArrayList;

public class Calle {
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;

    private Casillero casilleroOrigen;

    private Casillero casilleroDesino;

    public Calle() {
        this.obstaculo = null;
        this.sorpresa = null;
    }

    public void asignarOrigenYDestino(Casillero primerCasillero, Casillero segundoCasillero){
        this.casilleroOrigen = primerCasillero;
        this.casilleroDesino = segundoCasillero;
    }

    public boolean equals(Casillero primerCasillero, Casillero segundoCasillero){
        return (primerCasillero == casilleroOrigen & segundoCasillero == casilleroDesino);
    }

    public Calle(Obstaculo obstaculo, Sorpresa sorpresa) {
        this.obstaculo = obstaculo;
        this.sorpresa = sorpresa;
    }
    public Calle(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
        this.sorpresa = null;
    }
    public Calle(Sorpresa sorpresa) {
        this.obstaculo = null;
        this.sorpresa = sorpresa;
    }
}
