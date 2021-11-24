package Enfermedades;

import Consumibles.Medicamento;

import java.util.ArrayList;

public class Esguince  extends AbstractEnfermedad{
    //No sé como saber cuando le dio un Esguince a menos que sea provocado por un deporte
    private int saludFisicaMenor;

    public Esguince() {
        this.saludFisicaMenor = 30;
    }

    @Override
    public void afectar() {
        System.out.println("Afectar xd");
    }

    public Esguince(ArrayList<Medicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted, double duracion, boolean active,
                    int saludFisicaMenor) {
        super(posiblesMedicamentos, tipo, accepted, duracion, active);
        this.saludFisicaMenor = saludFisicaMenor;
    }

    @Override
    public void curar() {

    }
}
