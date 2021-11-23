package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.CreadorDeHabilidades.AbilityMaker;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class HabilidadFactory {

    static ArrayList<Arma> habilidades;

    public HabilidadFactory(){
        loadArmas();
    }

    private void loadArmas(){
        habilidades = AbilityMaker.loadAbilityList();
    }

    public static Arma getRandomHabilidad(){
        return habilidades.get(ThreadLocalRandom.current().nextInt(0, habilidades.size()));
    }

    public static Arma getHabilidad(String name){
        for (Arma habilidad:habilidades){
            if(habilidad.getNombre().equals(name))
                return habilidad;
        }
        return null;
    }

    public static Arma getHabilidad(int index){
        return habilidades.get(index);
    }
}
