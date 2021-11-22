package Strategy;

import Model.Jugador;

public class ControladorSocial implements IControlerStrategy {

    @Override
    public void satisfacer() {
        Jugador.getInstance().controladorSalud.modSaludSocial(40);
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(-25);
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(-15);
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);
    }
}
