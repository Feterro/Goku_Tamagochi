package Deportes;

import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.ModuloPersonajes.Jugador;

import java.util.ArrayList;

public class Karate extends Deporte{

    private static final long serialVersionUID = 4368L;

    public Karate(int aumentaProbLesion,EnumDeportes tipoDeporte,ArrayList<Arma> armas, String imagen) {
        super(aumentaProbLesion,tipoDeporte,armas, imagen);
        this.tipoDeporte = tipoDeporte;
    }

    @Override
    public void satisfacer() {
        Jugador.getInstance().getControladorSalud().modSaludSocial(10);
        Jugador.getInstance().velocidad -= 10;
        Jugador.getInstance().getControladorSalud().modSaludFisica(-5);

        System.out.println(armas + " ARMAS");
        Jugador.getInstance().agregarHabilidad(armas.get(0));
    }
}
