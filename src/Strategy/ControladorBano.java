package Strategy;

import Model.Jugador;

public class ControladorBano implements IControlerStrategy{

    @Override
    public void satisfacer() {
        Jugador.getInstance().controladorSalud.modSatisfaccionBano(45);
    }

}
