package edu.fiuba.algo3.modelo;

public class CuatroXCuatro extends Vehiculo {
    private int pozos_atravesados;

    public int sumarVecesPasadosEnPozo(){
        pozos_atravesados = pozos_atravesados + 1;
        return pozos_atravesados;
    }
}
