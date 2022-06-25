package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;

import java.util.ArrayList;
import java.util.Random;

public class ColocadorRandom implements ColocadorItems{
    public void agregarObstaculoYSorpresa(ArrayList<Casillero> casilleros){
        for (int i = 0; i < casilleros.size(); i++) {
            Casillero casillero = casilleros.get(i);
            if (this.esCalle(casillero)) {
                Obstaculo obstaculo = generarObstaculoAleatorio();
                Sorpresa sorpresa = generarSorpresaAleatoria();

                agregarObstaculoEn(casillero, obstaculo);
                agregarSorpresaEn(casillero, sorpresa);
            }
        }

    }

    // Para generar el escenario aleatorio (devuelve una sorpresa aleatoria)
    private Sorpresa generarSorpresaAleatoria() {
        ArrayList<Sorpresa> sorpresas = obtenerSorpresasPosibles();
        int indexRandom = new Random().nextInt(sorpresas.size()); // Un int entre 0 (incluyente) y size (excluyente)

        return sorpresas.get(indexRandom);
    }

    // Para generar el escenario aleatorio (devuelve un obstaculo aleatorio)
    private Obstaculo generarObstaculoAleatorio() {
        ArrayList<Obstaculo> obstaculos = obtenerObstaculosPosibles();
        int indexRandom = new Random().nextInt(obstaculos.size()); // Un int entre 0 (incluyente) y size (excluyente)

        return obstaculos.get(indexRandom);
    }

    // Para generar el escenario aleatorio (devuelve un array con las posibles sorpresas
    // incluido el SinSorpresa)
    private ArrayList<Sorpresa> obtenerSorpresasPosibles() {
        ArrayList<Sorpresa> sorpresas = new ArrayList<>() {{
            add(new SinSorpresa());
            add(new Favorable());
            add(new Desfavorable());
            add(new CambioVehiculo());
        }};

        return sorpresas;
    }

    // Para generar el escenario aleatorio (devuelve un array con los posibles obstaculos
    // incluido el SinObstaculo)
    private ArrayList<Obstaculo> obtenerObstaculosPosibles() {
        ArrayList<Obstaculo> obstaculos = new ArrayList<>() {{
            add(new SinObstaculo());
            add(new Piquete());
            add(new Policia());
            add(new Pozo());
        }};

        return obstaculos;
    }

    // Para generar el escenario aleatorio (verifica si el casillero representa una calle)
    private boolean esCalle(Casillero casillero) {
        Ubicacion ubicacion = casillero.obtenerUbicacion();
        return ubicacion.hayCalle();
    }

    public void agregarObstaculoEn(Casillero casillero, Obstaculo obstaculo) {
        casillero.asignarObstaculo(obstaculo);
    }

    public void agregarSorpresaEn(Casillero casillero, Sorpresa sorpresa) {
        casillero.asignarSorpresa(sorpresa);
    }


}
