package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;



import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class HabilidadFactory {

    static ArrayList<Arma> habilidades;

    public HabilidadFactory(){
        habilidades = new ArrayList<>();
    }

    public void loadArmas(){
        //Implementar con la carga de las armas serializables
    }

    public void cargaTemporal(){
        habilidades.add(new Arma.BuilderArma().setNombre("Karate").addApariencia("Karate.jpg").setDano(10).build());
        
    }

    public static Arma getRandomHabilidad(){
        return habilidades.get(ThreadLocalRandom.current().nextInt(0, habilidades.size()));
    }
}
