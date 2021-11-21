package TimeChecker;

public class Habitacion {

    private String nombre;
    private Integer posicion;
    private String fondo;

    public Habitacion(String nombre, Integer posicion, String fondo){
        this.nombre = nombre;
        this.posicion = posicion;
        this.fondo = fondo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

}

