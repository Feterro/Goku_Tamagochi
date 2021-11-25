package Deportes;

import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.ModuloPersonajes.Jugador;

import java.util.ArrayList;

public class Karate extends Deporte{

    public Karate(int aumentaProbLesion,EnumDeportes tipoDeporte,ArrayList<Arma> armas) {
        super(aumentaProbLesion,tipoDeporte,armas);
        this.tipoDeporte = tipoDeporte;
    }

    @Override
    public void satisfacer() {
        Jugador.getInstance().getControladorSalud().modSaludSocial(10);
        Jugador.getInstance().velocidad -= 10;
        Jugador.getInstance().getControladorSalud().modSaludFisica(-5);
    }
}
