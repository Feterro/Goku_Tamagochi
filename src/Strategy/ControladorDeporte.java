package Strategy;

import Deportes.EnumDeportes;
import Deportes.SportFactory;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.IControlerStrategy;

import java.util.HashMap;

public class ControladorDeporte implements IControlerStrategy{

    HashMap<EnumDeportes, IControlerStrategy> deportes;

    public ControladorDeporte(){
        deportes = new HashMap<>();
        deportes.put(EnumDeportes.FUTBOL,SportFactory.getInstance().getDeporte(EnumDeportes.FUTBOL));
        deportes.put(EnumDeportes.KARATE,SportFactory.getInstance().getDeporte(EnumDeportes.KARATE));
    }


    public void satisfacer(){
        deportes.get(Jugador.getInstance().deporteActual).satisfacer();
    }

}
