package Deportes;

import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.ModuloPersonajes.Jugador;

import java.util.ArrayList;

public class Futbol extends Deporte {

    private static final long serialVersionUID = 4367L;


    public Futbol(int aumentaProbLesion, EnumDeportes tipoDeporte, ArrayList<Arma> armas) {
        super(aumentaProbLesion, tipoDeporte,armas);
    }

    @Override
    public void satisfacer() {
        Jugador.getInstance().velocidad -= 10;
        Jugador.getInstance().getControladorSalud().modSaludSocial(10);
        Jugador.getInstance().getControladorSalud().modSatisfaccionHambre(-20);
        Jugador.getInstance().getControladorSalud().modSaludFisica(-15);
    }
}
