package Deportes;

import java.util.ArrayList;

public class Karate extends Deporte{
    //private ArrayList<Habilidad> habilidades;

    public Karate(int mejoraSaludFisica, int mejoraSaludMnetal, int aumentaProbLesion) {
        super(mejoraSaludFisica, mejoraSaludMnetal, aumentaProbLesion);
        //this.habilidades = habilidades;
    }

    public void curar() {
        //goku.getInstance().setEnfermo(False);
    }

    @Override
    public void satisfacer() {
        //goku.getInstance().Moverse....
    }
}
