package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;

import java.util.ArrayList;

public class Pelea {
    
    Goku personaje;
    Enemigo enemigo;
    ArrayList<Arma> combo;
    
    public Pelea(Goku personaje){
        this.personaje = personaje;
        crearEnemigo();
        combo = new ArrayList<>();
    }

    public void addToCombo(Arma habilidad){
        this.combo.add(habilidad);
    }

    public void doCombo(){
        ArrayList<Personaje> objetivos = new ArrayList<>();
        objetivos.add(enemigo);
        personaje.atacar(objetivos,combo);
    }

    private void crearEnemigo(){
        this.enemigo = EnemigoFactory.createNewEnemy();//Se crea un nuevo enemigo del factory de enemigos
    }

    public void atacar(){

        //Ataque propio
        System.out.print("Ataca: ");
        System.out.println(personaje.getNombre());
        doCombo();
        //Ataque enemigo
        if(enemigo.isAlive()){
            System.out.print("Ataca: ");
            System.out.println(enemigo.getNombre());
            enemigo.doCombo(personaje);
        }
        else {
            personaje.robarHabilidad(enemigo);
        }
    }



}
