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

    private final IMath RANDOM;

    public Policia(IMath imath) {
        this.RANDOM = imath;
    }

    public Policia() {
        this.RANDOM = new Random();
    }

    public Efecto atravesar(Auto auto) {
        double probabilidadParo = 0.5;
        this.probabilidad = this.RANDOM.random();
        return this.calcularEfecto(probabilidadParo, probabilidad);
    }

    public Efecto atravesar(Camioneta camioneta) {
        double probabilidadParo = 0.3;
        this.probabilidad = this.RANDOM.random();
        return this.calcularEfecto(probabilidadParo, probabilidad);
    }

    public Efecto atravesar(Moto moto) {
        double probabilidadParo = 0.8;
        this.probabilidad = this.RANDOM.random();
        return this.calcularEfecto(probabilidadParo, probabilidad) ;
    }

    private Efecto calcularEfecto(double probabilidadParo, double probabilidad){
        Efecto efecto = new EfectoGeneral();
        if(probabilidad <= probabilidadParo) {
            int incremento = 3;
            return new EfectoIncrementarMovimientos(efecto, incremento);
        }
        return efecto;
    }
}