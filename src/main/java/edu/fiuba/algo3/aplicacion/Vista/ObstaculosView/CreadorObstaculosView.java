package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.*;



public class CreadorObstaculosView {
    /*
    public void crear(Piquete piquete, Casillero casillero) {
        PiqueteView piqueteView = new PiqueteView(casillero);
    }

   public void crear(Piquete piquete, Casillero casillero){
>>>>>>> 5d3d3a82f0b5cd9a43bad7d3c64b0237c7eaf086
        PiqueteView piqueteView = new PiqueteView(casillero);

   }

<<<<<<< HEAD

    public ObstaculoView crear(Pozo pozo, Casillero casillero){
=======
    public void crear(Pozo pozo, Casillero casillero) {
>>>>>>> 5d3d3a82f0b5cd9a43bad7d3c64b0237c7eaf086
        PiqueteView piqueteView = new PiqueteView(casillero);
    }

<<<<<<< HEAD

    public ObstaculoView crear(Policia policia, Casillero casillero){
=======
    public void crear(Policia policia, Casillero casillero) {
>>>>>>> 5d3d3a82f0b5cd9a43bad7d3c64b0237c7eaf086
        PiqueteView piqueteView = new PiqueteView(casillero);
    }

<<<<<<< HEAD

    public ObstaculoView crear(SinObstaculo sinObstaculo, Casillero casillero){
=======
    public void crear(SinObstaculo sinObstaculo, Casillero casillero) {
>>>>>>> 5d3d3a82f0b5cd9a43bad7d3c64b0237c7eaf086
        PiqueteView piqueteView = new PiqueteView(casillero);
    }
<<<<<<< HEAD

=======
>>>>>>> 5d3d3a82f0b5cd9a43bad7d3c64b0237c7eaf086

    */
    public void crear(Obstaculo obstaculo, Casillero casillero) {
        if (obstaculo instanceof Piquete) {
            PiqueteView piqueteView = new PiqueteView(casillero);
        }

        if (obstaculo instanceof Pozo) {
            PozoView pozoView = new PozoView(casillero);
        }

        if (obstaculo instanceof Policia) {
            PoliciaView policiaView = new PoliciaView(casillero);
        }

        if (obstaculo instanceof SinObstaculo) {
            SinObstaculoView sinObstaculoView = new SinObstaculoView(casillero);
        }


    }
}