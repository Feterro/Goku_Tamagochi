package Deportes;

import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.IControlerStrategy;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Deporte implements Serializable, IControlerStrategy {

    protected  int aumentaProbLesion; //Indica cuanto aumenta la probab
    protected  EnumDeportes tipoDeporte;
    protected ArrayList<Arma> armas;
    private static final long serialVersionUID = 2001L;


    public Deporte() {}

    public Deporte(int aumentaProbLesion,EnumDeportes tipoDeporte,ArrayList<Arma> armas) {
        this.aumentaProbLesion = aumentaProbLesion;
        this.tipoDeporte = tipoDeporte;
        this.armas = armas;
    }

    public int getAumentaProbLesion() {
        return aumentaProbLesion;
    }

    public void setAumentaProbLesion(int aumentaProbLesion) {
        this.aumentaProbLesion = aumentaProbLesion;
    }

    public void curar(){
        if (Jugador.getInstance().controladorSalud.isEnfermo()){
            Jugador.getInstance().getControladorSalud().setEnfermo(false);
            if (Jugador.getInstance().controladorSalud.enfermedad.curarDeporte(this.tipoDeporte)){
                Jugador.getInstance().controladorSalud.setProbabilidadEnfermedad(0);
                Jugador.getInstance().controladorSalud.setEnfermo(false);
                Jugador.getInstance().cantidadDeDiasEnfermo = 0;
            }
        }
    }

    @Override
    public void satisfacer() {}
}


