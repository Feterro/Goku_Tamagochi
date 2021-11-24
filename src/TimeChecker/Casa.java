package TimeChecker;

import java.io.Serializable;
import java.util.HashMap;

public class Casa implements Serializable {

    private Habitacion habitacionActual;
    private HashMap<String, Habitacion> habitaciones = new HashMap<String, Habitacion>();
    private static final long serialVersionUID = 1001L;

    public Casa(){

    }

    Habitacion getHabitacionActual() {
        return habitacionActual;
    }

    public void setHabitacionActual(String nombre) {
        this.habitacionActual = getHabitacion(nombre);
    }

    public Habitacion getHabitacion(String nombre) {
        return habitaciones.get(nombre);
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitaciones.put(habitacion.getNombre(), habitacion);
    }

}
