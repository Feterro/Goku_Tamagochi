package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;

import java.util.ArrayList;

public class Calambre  extends AbstractEnfermedad{

    private int saludFisicaMenor;


    public Calambre() {
        //Si los valores menor a esto, le da un calambre
        //Agregar algo mas
        this.saludFisicaMenor = 42;
    }

    @Override
    public void afectar() {
        System.out.println("Afectar xd");
    }

    public Calambre(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted, boolean active,
                    int saludFisicaMenor, int probEnfermedadMenor) {
        super(posiblesMedicamentos, tipo, accepted, active);
        this.saludFisicaMenor = saludFisicaMenor;

    }

    public int getSaludFisicaMenor() {
        return saludFisicaMenor;
    }

    public void setSaludFisicaMenor(int saludFisicaMenor) {
        this.saludFisicaMenor = saludFisicaMenor;
    }


}
