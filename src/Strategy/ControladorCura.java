package Strategy;

import Consumibles.Medicamento;
import ModuloPelea.ModuloPersonajes.Jugador;

public class ControladorCura implements IControlerStrategy {

    @Override
    public void satisfacer(){
        if(Jugador.getInstance().controladorSalud.enfermedad.curarMedicamento(((Medicamento)Jugador.getInstance().consumible).getNombre())){
            Jugador.getInstance().controladorSalud.setProbabilidadEnfermedad(0);
            Jugador.getInstance().controladorSalud.modSatisfaccionHambre(-15);
            Jugador.getInstance().controladorSalud.modSaludFisica(-15);
            Jugador.getInstance().controladorSalud.setEnfermo(false);
            Jugador.getInstance().cantidadDeDiasEnfermo = 0;
            Jugador.getInstance().controladorSalud.verificar();
        }
    }
}
