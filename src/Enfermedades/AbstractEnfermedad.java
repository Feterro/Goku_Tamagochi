package Enfermedades;

import Consumibles.Medicamento;

import java.util.ArrayList;

public class AbstractEnfermedad {
    protected  ArrayList<Medicamento> posiblesMedicamentos;
    protected  boolean accepted; //No sé pa que
    protected  double duracion; //Si no se trata antes, muere
    protected  boolean active;


    public AbstractEnfermedad() {
        this.posiblesMedicamentos = new ArrayList<>();
        this.accepted = false;
        this.duracion = 0;
        this.active = true;
    }

    public AbstractEnfermedad(ArrayList<Medicamento> posiblesMedicamentos, boolean accepted, double duracion) {
        this.posiblesMedicamentos = posiblesMedicamentos;
        this.accepted = accepted;
        this.duracion = duracion;
        this.active = true; //Si se crea está enfermo
    }

    public ArrayList<Medicamento> getPosiblesMedicamentos() {
        return posiblesMedicamentos;
    }

    public void setPosiblesMedicamentos(ArrayList<Medicamento> posiblesMedicamentos) {
        this.posiblesMedicamentos = posiblesMedicamentos;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void curar(Medicamento medicamento){
        for (Medicamento med: posiblesMedicamentos) {
            //if (medicamento)
        }
    }

    public void afectar(){

    }

}
