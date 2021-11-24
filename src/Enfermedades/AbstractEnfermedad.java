package Enfermedades;

import Consumibles.Medicamento;

import java.util.ArrayList;

public abstract class AbstractEnfermedad implements ICura{
    protected  ArrayList<Medicamento> posiblesMedicamentos;
    protected  EnumTipoEnfermedad tipo;
    protected  boolean accepted; //No sé pa que
    protected  double duracion; //Si no se trata antes, muere
    protected  boolean active;


    public AbstractEnfermedad() {
        this.posiblesMedicamentos = new ArrayList<>();
        this.accepted = false;
        this.duracion = 0;
        this.active = true;
    }

    public AbstractEnfermedad(ArrayList<Medicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted, double duracion, boolean active) {
        this.posiblesMedicamentos = posiblesMedicamentos;
        this.tipo = tipo;
        this.accepted = accepted;
        this.duracion = duracion;
        this.active = active;
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

    public EnumTipoEnfermedad getTipo() {return tipo;}

    public void setTipo(EnumTipoEnfermedad tipo) {this.tipo = tipo;}

    public void curar(Medicamento medicamento){
        for (Medicamento med: posiblesMedicamentos) {
            //if (medicamento)
        }
    }

    public abstract void afectar();

}
