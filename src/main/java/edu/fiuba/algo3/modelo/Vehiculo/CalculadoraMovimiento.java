package edu.fiuba.algo3.modelo.Vehiculo;


public class CalculadoraMovimiento {
    private int movimientos;

    public CalculadoraMovimiento(){
        this.movimientos = 0;
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void disminuirMovimientos(int disminucion){this.movimientos -= disminucion;}

    public int dividirMovimientos(int divisor){return (this.movimientos / divisor);}

   // public int multplicadorMovimientos(int multiplicador){return this.movimientos * multiplicador;}

    public boolean verificarMovimientos(int cantMovimientos){
        return (this.movimientos == cantMovimientos);
    }
}
