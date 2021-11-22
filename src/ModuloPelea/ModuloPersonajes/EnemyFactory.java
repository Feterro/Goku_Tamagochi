package ModuloPersonajes;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import ModuloHabilidades.*;

public class EnemyFactory {
    
    static ArrayList<Enemigo> enemigos;
    static ArrayList<Habilidad> habilidades;

    public EnemyFactory(){
        enemigos = new ArrayList();
        habilidades = new ArrayList<>();
        cargaTemporal();
    }

    private void loadEnemies(){//Carga los enemigos serializadas de la progra 1
            //TODO: Load file
    }

    private void loadHabilidades(){//Carga las armas serializadas de la progra 1
        //TODO: Load File
    }

    public static Enemigo createNewEnemy(){
        //Clonar un enemigo de la fabrica de prototipos
        PersonajeBase enemy = enemigos.get(ThreadLocalRandom.current().nextInt(0, enemigos.size())).deepClone();

        //Asignacion de las armas aleatorias al enemigo
        for(int i = 0; i < 3;i++){
            enemy.agregarHabilidad(habilidades.get(ThreadLocalRandom.current().nextInt(0, habilidades.size())));
        }
        return (Enemigo)enemy;
    }

    public void cargaTemporal(){
        //Carga de armas manual
        habilidades.add(new Karate());
        habilidades.add(new Kamehameha());
        habilidades.add(new Bazooka());
        habilidades.add(new JiuJitsu());

        //Carga de personajes
        enemigos.add(new Enemigo("Saibaman","Saibaman.jpg",30));
        enemigos.add(new Enemigo("Brolly","Brolly.jpg",200));
        enemigos.add(new Enemigo("Bu","Bu.jpg",125));

    }

}
