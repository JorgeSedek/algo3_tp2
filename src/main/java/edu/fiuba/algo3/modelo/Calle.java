package edu.fiuba.algo3.modelo;

public class Calle {
    private Obstaculo obstaculo;
    private EntreCalle primerEntreCalle;
    private EntreCalle segundaEntreCalle;

    public Calle(){
        primerEntreCalle = null;
        segundaEntreCalle = null;
    }
    public Calle(EntreCalle unaEntreCalle, EntreCalle otraEntreCalle){
        primerEntreCalle = unaEntreCalle;
        segundaEntreCalle = otraEntreCalle;
    }

    public void asignarEntreCalles(EntreCalle unaEntreCalle, EntreCalle otraEntreCalle){
        primerEntreCalle = unaEntreCalle;
        segundaEntreCalle = otraEntreCalle;
   }

   public void asignarObstaculo(Obstaculo unObstaculo){
        obstaculo = unObstaculo;
   }

   public EntreCalle EntreCalleEnFrente(EntreCalle unaEntreCalle){
        if (unaEntreCalle == primerEntreCalle){
            return segundaEntreCalle;
        }
        if (unaEntreCalle == segundaEntreCalle){
            return primerEntreCalle;
        }
        return null;
   }
   public Obstaculo obstaculo(){
        return obstaculo;
   }

}
