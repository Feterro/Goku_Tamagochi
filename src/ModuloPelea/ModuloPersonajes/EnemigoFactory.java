package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.Apariencia.LvlImages;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.CreadorDeEnemigos.EnemyMaker;
import ModuloPelea.CreadorDeHabilidades.AbilityMaker;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EnemigoFactory {
    
    static ArrayList<Enemigo> enemigos;

    public EnemigoFactory(){
        loadEnemies();
    }

    private void loadEnemies(){//Carga los enemigos serializadas de la progra 1
        enemigos = EnemyMaker.loadAbilityList();
    }

    public static Enemigo createNewEnemy(){
        //Clonar un enemigo de la fabrica de prototipos
        Personaje enemy = enemigos.get(ThreadLocalRandom.current().nextInt(0, enemigos.size())).deepClone();

        //Asignacion de las armas aleatorias al enemigo
        for(int i = 0; i < 3;i++){
            enemy.getArmas().addArma(HabilidadFactory.getRandomHabilidad());
        }
        return (Enemigo)enemy;
    }


}
