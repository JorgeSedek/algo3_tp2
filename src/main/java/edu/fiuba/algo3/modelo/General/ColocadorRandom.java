package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Meta.MetaFinal;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;

import java.util.ArrayList;
import java.util.Random;

public class ColocadorRandom implements ColocadorItems{

    // Dado un array de casilleros, agrega obstaculos y sorpresas de forma aleatoria en los
    // casilleros que sean calle
    public void agregarObstaculosYSorpresas(ArrayList<Casillero> casilleros){
        for (int i = 0; i < casilleros.size(); i++) {
            Casillero casillero = casilleros.get(i);
            if (this.esCalle(casillero)) {
                agregarObstaculoEn(casillero, generarObstaculoAleatorio());
                agregarSorpresaEn(casillero, generarSorpresaAleatoria());
            }
        }
    }

    // Dado un array de casilleros, agrega una meta de forma aleatoria en alguno de los casilleros
    // de la ultima columna (que sean una calle)
    public void agregarMeta(ArrayList<Casillero> casilleros) {
        ArrayList<Casillero> casillerosCalleUltimaColumna = new ArrayList<Casillero>(); // Un array con los casilleros de la ultima columna que son calle
        for (int i = 0; i < casilleros.size(); i++) {
            // Voy a buscar los casilleros candidatos y agregarlos al array
            Casillero casillero = casilleros.get(i);
            if (this.estaEnLaUltimaColumna(casillero) & casillero.obtenerUbicacion().hayCalle()) {
                casillerosCalleUltimaColumna.add(casillero);
            }
        }

        // Busco de forma random el casillero que tendra la meta entre los candidatos
        int indexRandom = new Random().nextInt(casillerosCalleUltimaColumna.size()); // Un int entre 0 (incluyente) y size (excluyente)
        Casillero casilleroFinal = casillerosCalleUltimaColumna.get(indexRandom);

        // Limpio de obstaculos y sorpresas el casillero que va a tener la meta
        casilleroFinal.asignarSorpresa(new SinSorpresa());
        casilleroFinal.asignarObstaculo(new SinObstaculo());

        // Agrego finalmente la meta al casillero
        agregarMetaEn(casilleroFinal, new MetaFinal());
    }

    private boolean estaEnLaUltimaColumna(Casillero casillero) {
        int columnasEscenario = Escenario.getInstance().obtenerNumeroDeColumnas();
        int columnaCasillero = casillero.obtenerUbicacion().obtenerColumna();

        return columnaCasillero == columnasEscenario;
    }


    // Para generar el escenario aleatorio (devuelve una sorpresa aleatoria, incluido el SinSorpresa)
    private Sorpresa generarSorpresaAleatoria() {
        ArrayList<Sorpresa> sorpresas = obtenerSorpresasPosibles();
        int indexRandom = new Random().nextInt(sorpresas.size()); // Un int entre 0 (incluyente) y size (excluyente)

        return sorpresas.get(indexRandom);
    }

    // Para generar el escenario aleatorio (devuelve un obstaculo aleatorio, incluido el SinObstaculo)
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

    public void agregarMetaEn(Casillero casillero, Meta meta) {
        casillero.asignarMeta(meta);
    }
}
