package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.*;

public class CreadorObstaculosView {
    /*
    public void crear(Piquete piquete, Casillero casillero) {
        PiqueteView piqueteView = new PiqueteView(casillero);
    }

    public void crear(Pozo pozo, Casillero casillero) {
        PiqueteView piqueteView = new PiqueteView(casillero);
    }

    public void crear(Policia policia, Casillero casillero) {
        PiqueteView piqueteView = new PiqueteView(casillero);
    }

    public void crear(SinObstaculo sinObstaculo, Casillero casillero) {
        PiqueteView piqueteView = new PiqueteView(casillero);
    }
    */
    public void crear(Obstaculo obstaculo, Casillero casillero) {
        if (obstaculo instanceof Piquete) {
            PiqueteView piqueteView = new PiqueteView(casillero);
        }
        /*
        if (obstaculo instanceof Pozo) {
            PozoView pozoView = new PozoView(casillero);
        }
        if (obstaculo instanceof Policia) {
            PoliciaView policiaView = new PoliciaView(casillero);
        }
        if (obstaculo instanceof SinObstaculo) {
            SinObstaculoView sinObstaculoView = new SinObstaculoView(casillero);
        }
        */
    }
}
