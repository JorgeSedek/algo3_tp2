package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Math.Random;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Policia implements Obstaculo {
    private int incremento = 3;
    private double probabilidad;

    private IMath random = new Random();

    public Efecto atravesar(Auto auto) {
        double probabilidadParo = 0.5;
        //random = new Random();
        //random.darNumeroAleatorio(probabilidad);
        this.probabilidad = this.random.darNumeroAleatorio();
        return this.calcularEfecto(probabilidadParo, probabilidad);
    }

    public Efecto atravesar(Camioneta camioneta) {
        double probabilidadParo = 0.3;
        //random = new Random();
        this.probabilidad = this.random.darNumeroAleatorio();
        return this.calcularEfecto(probabilidadParo, probabilidad);
    }

    public Efecto atravesar(Moto moto) {
        double probabilidadParo = 0.8;
        //random = new Random();
        this.probabilidad = this.random.darNumeroAleatorio();
        return this.calcularEfecto(probabilidadParo, probabilidad) ;
    }

    public Efecto calcularEfecto(double probabilidadParo, double probabilidad){
        //double probabilidad = Math.random();
        if(probabilidad <= probabilidadParo) {
            Efecto efecto = new EfectoGeneral();
            return new EfectoIncrementarMovimientos(efecto, incremento);
        }
        return new EfectoGeneral();
    }

}