package edu.fiuba.algo3.modelo;

public class Calle {
    private Obstaculo obstaculo;
    private EntreCalle primerEntreCalle;
    private EntreCalle segundaEntreCalle;

    public Calle(){
        primerEntreCalle = new EntreCalle();
        segundaEntreCalle = new EntreCalle();
    }
    public Calle(EntreCalle unaEntreCalle, EntreCalle otraEntreCalle){
        primerEntreCalle = unaEntreCalle;
        segundaEntreCalle = otraEntreCalle;
    }

    public EntreCalle entreCallePrimera(){
        return this.primerEntreCalle;
    }

    public EntreCalle entreCalleSegunda(){
        return this.segundaEntreCalle;
    }

    public void asignarEntreCalles(EntreCalle unaEntreCalle, EntreCalle otraEntreCalle){
        primerEntreCalle = unaEntreCalle;
        segundaEntreCalle = otraEntreCalle;
   }

   public void asignarObstaculo(Obstaculo unObstaculo){
        obstaculo = unObstaculo;
   }


   public EntreCalle otraEntreCalle(EntreCalle unaEntreCalle){
        if (unaEntreCalle == primerEntreCalle){
            return segundaEntreCalle;
        }
      return primerEntreCalle;
   }

   public Obstaculo obstaculo(){
        return obstaculo;
   }

}
