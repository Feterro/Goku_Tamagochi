package Consumibles;

public class Medicamento extends Consumible {
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
}
