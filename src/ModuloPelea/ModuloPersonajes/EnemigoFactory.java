package ModuloPelea.ModuloPersonajes;

import ModuloPelea.ModuloHabilidades.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EnemigoFactory {
    
    static ArrayList<Enemigo> enemigos;

    public EnemigoFactory(){
        enemigos = new ArrayList();
        cargaTemporal();
    }

    private void loadEnemies(){//Carga los enemigos serializadas de la progra 1
            //TODO: Load file
    }

    public static Enemigo createNewEnemy(){
        //Clonar un enemigo de la fabrica de prototipos
        PersonajeBase enemy = enemigos.get(ThreadLocalRandom.current().nextInt(0, enemigos.size())).deepClone();

        //Asignacion de las armas aleatorias al enemigo
        for(int i = 0; i < 3;i++){
            enemy.agregarHabilidad(HabilidadFactory.getRandomHabilidad());
        }
        return (Enemigo)enemy;
    }

    public void cargaTemporal(){
        //Carga de armas manual


        //Carga de personajes
        enemigos.add(new Enemigo("Saibaman","Saibaman.jpg",30));
        enemigos.add(new Enemigo("Brolly","Brolly.jpg",200));
        enemigos.add(new Enemigo("Bu","Bu.jpg",125));

    }

}
