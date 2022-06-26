package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Policia implements Obstaculo {
    private int incremento = 3;
    private double probabilidad;

    private IMath random;

    public Policia(IMath imath) {
        this.random = imath;
    }

    public Policia() {
        this.random = null;
    }

    public Efecto atravesar(Auto auto, Efecto efecto) {
        double probabilidadParo = 0.5;
        this.probabilidad = this.random.random();
        return this.calcularEfecto(probabilidadParo, probabilidad, efecto);
    }

    public Efecto atravesar(Camioneta camioneta, Efecto efecto) {
        double probabilidadParo = 0.3;
        this.probabilidad = this.random.random();
        return this.calcularEfecto(probabilidadParo, probabilidad, efecto);
    }

    public Efecto atravesar(Moto moto, Efecto efecto) {
        double probabilidadParo = 0.8;
        this.probabilidad = this.random.random();
        return this.calcularEfecto(probabilidadParo, probabilidad, efecto) ;
    }

    private Efecto calcularEfecto(double probabilidadParo, double probabilidad, Efecto efecto){
        if(probabilidad <= probabilidadParo) {
            return new EfectoIncrementarMovimientos(efecto, incremento);
        }
        return efecto;
    }
}