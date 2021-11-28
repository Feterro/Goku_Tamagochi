package Consumibles;

import java.io.Serializable;

public abstract class Consumible implements Serializable {
    protected int cantidadDisponible;
    //Efecto no está porque solo lo tiene alimento, med no ocupa
    //Nombres son diferentes enums

    public Consumible() {
    }

    public Consumible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void consumir() {
        if (cantidadDisponible > 0) {
            cantidadDisponible -= 1;
        }
    }

    public void agregar() {
        cantidadDisponible -= 1;
    }
}
