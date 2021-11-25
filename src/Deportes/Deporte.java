package Deportes;

import Enfermedades.ICura;
import LibreriaPersonajes.TDA.Arma;
import Strategy.IControlerStrategy;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Deporte implements IControlerStrategy, ICura, Serializable {

    protected  int mejoraSaludFisica;
    protected  int mejoraSaludMental;
    protected  int aumentaProbLesion; //Indica cuanto aumenta la probab
    protected  EnumDeportes tipoDeporte;
    protected ArrayList<Arma> armas;

    public Deporte() {}

    public Deporte(int mejoraSaludFisica, int mejoraSaludMental, int aumentaProbLesion,EnumDeportes tipoDeporte,ArrayList<Arma> armas) {
        this.mejoraSaludFisica = mejoraSaludFisica;
        this.mejoraSaludMental = mejoraSaludMental;
        this.aumentaProbLesion = aumentaProbLesion;
        this.tipoDeporte = tipoDeporte;
        this.armas = armas;
    }

    public int getAumentaProbLesion() {
        return aumentaProbLesion;
    }

    public void setAumentaProbLesion(int aumentaProbLesion) {
        this.aumentaProbLesion = aumentaProbLesion;
    }
}


