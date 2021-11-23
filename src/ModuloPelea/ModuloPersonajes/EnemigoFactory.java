package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.Apariencia.LvlImages;
import LibreriaPersonajes.TDA.Personaje;

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
        Personaje enemy = enemigos.get(ThreadLocalRandom.current().nextInt(0, enemigos.size())).deepClone();

        //Asignacion de las armas aleatorias al enemigo
        for(int i = 0; i < 3;i++){
            enemy.getArmas().addArma(HabilidadFactory.getRandomHabilidad());
        }
        return (Enemigo)enemy;
    }

    public void cargaTemporal(){
        //Carga de personajes
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(150).setNombre("Bu").addApariencia("Bu.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(75).setNombre("Saibamalo").addApariencia("Saibamalo.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(200).setNombre("Broly").addApariencia("Broly.jpg").build()));
    }

}
