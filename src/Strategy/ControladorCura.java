package Strategy;

import Model.Jugador;

public class ControladorCura implements IControlerStrategy {

    @Override
    public void satisfacer(){//TODO IF De si la cura sirve para esa enfermedad
        //Consumible consumible = Bodega.getInstance().getConsumible(); //TODO ver como hacer que agarre uno especifico
        int mejora = 0; // consumible.getmejora() //TODO hay que hacer un get solo de comida y otro de medicinas
        Jugador.getInstance().controladorSalud.modProbabilidadEnfermedad(-100);
        Jugador.getInstance().controladorSalud.setEnfermo(false);
    }
}
