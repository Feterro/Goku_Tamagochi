package Consumibles;

import Enfermedades.ICura;

public class Medicamento extends Consumible implements ICura {
    private EnumMedicamento nombre;

    public Medicamento() {}

    public Medicamento(int cantidadDisponible, EnumMedicamento nombre) {
        super(cantidadDisponible);
        this.nombre = nombre;
    }

    public EnumMedicamento getNombre() {
        return nombre;
    }

    public void setNombre(EnumMedicamento nombre) {
        this.nombre = nombre;
    }

    @Override
    public void curar() {

    }
}
