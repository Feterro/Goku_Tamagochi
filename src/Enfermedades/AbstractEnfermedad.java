package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;
import Deportes.EnumDeportes;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractEnfermedad implements Serializable {
    protected ArrayList<EnumMedicamento> posiblesMedicamentos;
    protected ArrayList<EnumDeportes> posiblesDeportes;
    protected EnumTipoEnfermedad tipo;
    protected boolean accepted; //No sé pa que
    protected boolean active;


    public AbstractEnfermedad() {
        this.posiblesMedicamentos = new ArrayList<>();
        this.accepted = false;
        this.active = true;
    }

    public AbstractEnfermedad(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted) {
        this.posiblesMedicamentos = posiblesMedicamentos;
        this.tipo = tipo;
        this.accepted = accepted;
        this.active = true;
    }

    public ArrayList<EnumMedicamento> getPosiblesMedicamentos() {
        return posiblesMedicamentos;
    }

    public ArrayList<EnumDeportes> getPosiblesDeportes() {
        return posiblesDeportes;
    }

    public void setPosiblesMedicamentos(ArrayList<EnumMedicamento> posiblesMedicamentos) {
        this.posiblesMedicamentos = posiblesMedicamentos;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public EnumTipoEnfermedad getTipo() {return tipo;}

    public void setTipo(EnumTipoEnfermedad tipo) {this.tipo = tipo;}

    public boolean curarMedicamento(EnumMedicamento medicamento){
        for (EnumMedicamento med: posiblesMedicamentos) {
            if (med.toString().equals(medicamento.toString()))
                return true;
        }
        return false;
    }

    public boolean curarDeporte(EnumDeportes deporte){
        for (EnumDeportes dep: posiblesDeportes) {
            if (dep.toString().equals(deporte.toString()))
                return true;
        }
        return false;
    }
    public abstract void afectar();

}
