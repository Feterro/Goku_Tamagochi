package Strategy;

import ModuloPelea.ModuloPersonajes.Jugador;


public class ControladorBano implements IControlerStrategy{

    @Override
    public void satisfacer() {
        Jugador.getInstance().controladorSalud.modSatisfaccionBano(45);
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(-15);
        Jugador.getInstance().controladorSalud.modSaludSocial(-10);
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);

        Jugador.getInstance().controladorSalud.verificar();

    }

}
