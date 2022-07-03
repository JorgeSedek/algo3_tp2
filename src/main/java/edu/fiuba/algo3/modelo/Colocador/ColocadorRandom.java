package edu.fiuba.algo3.modelo.Colocador;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Math.Random;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Meta.MetaFinal;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;

import java.util.ArrayList;

public class ColocadorRandom implements ColocadorItems{
    private final IMath RANDOM;
    private final ArrayList<Sorpresa> SORPRESAS = new ArrayList<>() {{
        add(new SinSorpresa());
        add(new Favorable());
        add(new Desfavorable());
        add(new CambioVehiculo());
    }};

    private final ArrayList<Obstaculo> OBSTACULOS = new ArrayList<>() {{
        add(new SinObstaculo());
        add(new Piquete());
        add(new Policia(new Random()));
        add(new Pozo());
    }};

    public ColocadorRandom(IMath random) {
        RANDOM = random;
    }

    public void agregarObjetosAEscenario(ArrayList<Casillero> casilleros){
        ArrayList<Casillero> casillerosCalleUltimaColumna = new ArrayList<>();
        for (Casillero casillero : casilleros) {
            if (casillero.hayCalle()) {
                agregarSorpresaEn(casillero, generarSorpresaAleatoria());
                agregarObstaculoEn(casillero, generarObstaculoAleatorio());
                if(casillero.podesTenerMeta()) {
                    casillerosCalleUltimaColumna.add(casillero);
                }
            }
        }
        int indexRandom = (int) (RANDOM.random() * casillerosCalleUltimaColumna.size());
        Casillero casilleroFinal = casillerosCalleUltimaColumna.get(indexRandom);

        casilleroFinal.asignarSorpresa(new SinSorpresa());
        casilleroFinal.asignarObstaculo(new SinObstaculo());

        agregarMetaEn(casilleroFinal, new MetaFinal());
    }

    private Sorpresa generarSorpresaAleatoria() {
        int indexRandom = (int) (RANDOM.random() * SORPRESAS.size());
        return SORPRESAS.get(indexRandom);
    }

    private Obstaculo generarObstaculoAleatorio() {
        int indexRandom = (int) (RANDOM.random() * OBSTACULOS.size());
        return OBSTACULOS.get(indexRandom);
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
