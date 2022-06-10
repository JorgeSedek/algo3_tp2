package edu.fiuba.algo3.modelo;

public class Calle {
    private Obstaculo obstaculo;
    private Casillero primerCasillero;
    private Casillero segundaCasillero;

    public Calle(){
        primerCasillero = new Casillero();
        segundaCasillero = new Casillero();
    }
    public Calle(Casillero unaCasillero, Casillero otraCasillero){
        primerCasillero = unaCasillero;
        segundaCasillero = otraCasillero;
    }

    public Casillero entreCallePrimera(){
        return this.primerCasillero;
    }

    public Casillero entreCalleSegunda(){
        return this.segundaCasillero;
    }

    public void asignarEntreCalles(Casillero unaCasillero, Casillero otraCasillero){
        primerCasillero = unaCasillero;
        segundaCasillero = otraCasillero;
   }

   public void asignarObstaculo(Obstaculo unObstaculo){
        obstaculo = unObstaculo;
   }


   public Casillero otraEntreCalle(Casillero unaCasillero){
        if (unaCasillero == primerCasillero){
            return segundaCasillero;
        }
      return primerCasillero;
   }

   public Obstaculo obstaculo(){
        return obstaculo;
   }

}
