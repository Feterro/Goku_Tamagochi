package Deportes;

public class Futbol extends Deporte {


    public Futbol(int mejoraSaludFisica, int mejoraSaludMnetal, int aumentaProbLesion) {
        super(mejoraSaludFisica, mejoraSaludMnetal, aumentaProbLesion);
    }

    public void curar() {
        //goku.getInstance().setEnfermo(False);
    }

    @Override
    public void satisfacer() {
        //goku.getInstance().Moverse....
    }
}
