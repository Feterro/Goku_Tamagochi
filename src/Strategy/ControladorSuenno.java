package Strategy;

import ModuloPelea.ModuloPersonajes.Jugador;

public class ControladorSuenno implements IControlerStrategy {

    @Override
    public void satisfacer() {
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(100);
        Jugador.getInstance().controladorSalud.modSaludFisica(25);
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(-25);
        Jugador.getInstance().controladorSalud.modSaludSocial(-10);
        Jugador.getInstance().controladorSalud.verificar();
    }

    public void madrugar(){
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(-50);
        Jugador.getInstance().controladorSalud.modSaludSocial(-25);
        Jugador.getInstance().controladorSalud.modSaludFisica(-25);
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(-25);
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);
        Jugador.getInstance().controladorSalud.verificar();
    }
}
