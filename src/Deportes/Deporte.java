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
    private static final long serialVersionUID = 4366L;
    private String imagen;

    public Deporte() {}

    public Deporte(int aumentaProbLesion,EnumDeportes tipoDeporte,ArrayList<Arma> armas, String imagen) {
        this.aumentaProbLesion = aumentaProbLesion;
        this.tipoDeporte = tipoDeporte;
        this.armas = armas;
        this.imagen = imagen;
    }

    public int getAumentaProbLesion() {
        return aumentaProbLesion;
    }

    public void setAumentaProbLesion(int aumentaProbLesion) {
        this.aumentaProbLesion = aumentaProbLesion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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


