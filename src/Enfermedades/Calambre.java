package Enfermedades;

import Consumibles.Medicamento;

import java.util.ArrayList;

public class Calambre  extends AbstractEnfermedad{

    private int saludFisicaMenor;
    private int probEnfermedadMenor;

    public Calambre() {
        //Si los valores menor a esto, le da un calambre
        //Agregar algo mas
        this.saludFisicaMenor = 42;
        this.probEnfermedadMenor = 50;
    }

    public Calambre(ArrayList<Medicamento> posiblesMedicamentos, boolean accepted, double duracion, int saludFisicaMenor, int probEnfermedadMenor) {
        super(posiblesMedicamentos, accepted, duracion);
        this.saludFisicaMenor = saludFisicaMenor;
        this.probEnfermedadMenor = probEnfermedadMenor;
    }

    public int getSaludFisicaMenor() {
        return saludFisicaMenor;
    }

    public void setSaludFisicaMenor(int saludFisicaMenor) {
        this.saludFisicaMenor = saludFisicaMenor;
    }

    public int getProbEnfermedadMenor() {
        return probEnfermedadMenor;
    }

    public void setProbEnfermedadMenor(int probEnfermedadMenor) {
        this.probEnfermedadMenor = probEnfermedadMenor;
    }
}
