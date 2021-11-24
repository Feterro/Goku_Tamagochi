package Deportes;

import Enfermedades.ICura;
import Strategy.IControlerStrategy;

public abstract class Deporte implements IControlerStrategy, ICura {

    protected  int mejoraSaludFisica;
    protected  int mejoraSaludMnetal;
    protected  int aumentaProbLesion; //Indica cuanto aumenta la probab

    public Deporte() {}

    public Deporte(int mejoraSaludFisica, int mejoraSaludMnetal, int aumentaProbLesion) {
        this.mejoraSaludFisica = mejoraSaludFisica;
        this.mejoraSaludMnetal = mejoraSaludMnetal;
        this.aumentaProbLesion = aumentaProbLesion;
    }

    public int getAumentaProbLesion() {
        return aumentaProbLesion;
    }

    public void setAumentaProbLesion(int aumentaProbLesion) {
        this.aumentaProbLesion = aumentaProbLesion;
    }
}


