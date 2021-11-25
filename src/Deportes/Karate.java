package Deportes;

import LibreriaPersonajes.TDA.Arma;

import java.util.ArrayList;

public class Karate extends Deporte{

    public Karate(int mejoraSaludFisica, int mejoraSaludMental, int aumentaProbLesion,EnumDeportes tipoDeporte,ArrayList<Arma> armas) {
        super(mejoraSaludFisica, mejoraSaludMental, aumentaProbLesion,tipoDeporte,armas);
        this.tipoDeporte = tipoDeporte;
    }

    public void curar() {
        //goku.getInstance().setEnfermo(False);
    }

    @Override
    public void satisfacer() {
        //goku.getInstance().Moverse....
    }
}
