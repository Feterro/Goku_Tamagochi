package ModuloPelea.ModuloPersonajes;

import ModuloPelea.ModuloHabilidades.Bazooka;
import ModuloPelea.ModuloHabilidades.JiuJitsu;
import ModuloPelea.ModuloHabilidades.Kamehameha;
import ModuloPelea.ModuloHabilidades.Karate;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class HabilidadFactory {

    static ArrayList<Habilidad> habilidades;

    public HabilidadFactory(){
        habilidades = new ArrayList<>();
    }

    public void loadArmas(){
        //Implementar con la carga de las armas serializables
    }

    public void cargaTemporal(){
        habilidades.add(new Karate());
        habilidades.add(new Kamehameha());
        habilidades.add(new Bazooka());
        habilidades.add(new JiuJitsu());
    }

    public static Habilidad getRandomHabilidad(){
        return habilidades.get(ThreadLocalRandom.current().nextInt(0, habilidades.size()));
    }
}
