package Strategy;

import Model.Jugador;

public class ControladorComer implements IControlerStrategy{

    @Override
    public void satisfacer(){ //TODO Aumentar Liquidos y Solidos consumidos
        //Consumible consumible = Bodega.getInstance().getConsumible(); //TODO ver como hacer que agarre uno especifico
        int mejora = 0; // consumible.getmejora()
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(mejora);
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(mejora/2);
        Jugador.getInstance().controladorSalud.modSatisfaccionBano(-mejora);
        Jugador.getInstance().controladorSalud.modSaludSocial(-10);
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);
    }
}
