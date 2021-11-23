package Consumibles;

public class Alimento extends Consumible{
    private EnumAlimento nombre;
    private EnumTipoAlimento tipo;
    private int puntosEnergía;

    public Alimento() {}

    public Alimento(int cantidad, EnumAlimento nombre, EnumTipoAlimento tipo, int puntosEnergía) {
        super(cantidad);
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntosEnergía = puntosEnergía;
    }

    public EnumAlimento getNombre() {
        return nombre;
    }

    public void setNombre(EnumAlimento nombre) {
        this.nombre = nombre;
    }

    public int getPuntosEnergía() {
        return puntosEnergía;
    }

    public void setPuntosEnergía(int puntosEnergía) {
        this.puntosEnergía = puntosEnergía;
    }

    public EnumTipoAlimento getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoAlimento tipo) {
        this.tipo = tipo;
    }
}
