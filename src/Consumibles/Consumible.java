package Consumibles;

public abstract class Consumible {
    protected int cantidadDisponible;
    //Efecto no está porque solo lo tiene alimento, med no ocupa
    //Nombres son diferentes enums

    public Consumible() {}

    public Consumible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
