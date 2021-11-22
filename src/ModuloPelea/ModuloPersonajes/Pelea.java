package ModuloPersonajes;

import java.util.ArrayList;

public class Pelea {
    
    Personaje personaje;
    Enemigo enemigo;
    ArrayList<Habilidad> combo;
    
    public Pelea(Personaje personaje){
        this.personaje = personaje;
        crearEnemigo();
        combo = new ArrayList<>();
    }

    public void addToCombo(Habilidad habilidad){
        this.combo.add(habilidad);
    }

    public void doCombo(){
        for (Habilidad habilidad : combo) {
            habilidad.doSomething(enemigo);
        }
    }

    private void crearEnemigo(){
        this.enemigo = EnemyFactory.createNewEnemy();//Se crea un nuevo enemigo del factory de enemigos
    }

    public void atacar(){
        //Ataque propio
        System.out.print("Ataca: ");
        System.out.println(personaje.getName());
        doCombo();
        //Ataque enemigo
        System.out.print("Ataca: ");
        System.out.println(enemigo.getName());
        enemigo.doCombo(personaje);
    }



}
