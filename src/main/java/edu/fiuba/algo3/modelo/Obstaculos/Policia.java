package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
//import edu.fiuba.algo3.modelo.General.Random;

public class Policia implements Obstaculo {
    private int incremento = 3;
    //private double probabilidad = Math.random();

    //Random random;

    public Efecto atravesar(Auto auto) {
        double probabilidadParo = 0.5;
        return this.calcularEfecto(probabilidadParo);
    }

    public Efecto atravesar(Camioneta camioneta) {
        double probabilidadParo = 0.3;
        return this.calcularEfecto(probabilidadParo);
    }

    public Efecto atravesar(Moto moto) {
        double probabilidadParo = 0.8;
        return this.calcularEfecto(probabilidadParo);
    }

    public Efecto calcularEfecto(double probabilidadParo) {
        double probabilidad = Math.random();
        if(probabilidad <= probabilidadParo) {
            Efecto efecto = new EfectoGeneral();
            return new EfectoIncrementarMovimientos(efecto, incremento);
        }
        return new EfectoGeneral();
    }
}