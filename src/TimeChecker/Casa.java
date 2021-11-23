package TimeChecker;

import java.util.HashMap;

public class Casa {

    private Habitacion habitacionActual;
    private HashMap<String, Habitacion> habitaciones = new HashMap<String, Habitacion>();

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

    // PENDIENTE NO RECUERSO PARA QUÉ ERA xD.
    public void moverse(){

    }
}
