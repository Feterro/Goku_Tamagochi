package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import Strategy.IControlerStrategy;

import java.util.ArrayList;

public class ControladorPelea implements IControlerStrategy {


    private Enemigo enemigo;
    public boolean peleando;

    public ControladorPelea(){}

    public void crearEnemigo(){
        this.enemigo = EnemigoFactory.createNewEnemy();//Se crea un nuevo enemigo del factory de enemigos
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public void atacar(){
        Jugador personaje = Jugador.getInstance();
        if (Jugador.getInstance().isAlive()) {
            //Ataque propio
            System.out.print("Ataca: ");
            System.out.println(personaje.getNombre());
            personaje.doCombo(enemigo);
            Jugador.getInstance().partida.getJuego().notificaciones.getItems().add("La vida de " + enemigo.getNombre() + " es " + enemigo.getVida());

            //Ataque enemigo
        }else{
            Jugador.getInstance().partida.getJuego().notificaciones.getItems().add("Gokú fue derrotado");
            Jugador.getInstance().partida.getJuego().getPersonajeEnemigo().setVisible(false);
            peleando = false;
        }
        if(enemigo.isAlive()){
            System.out.print("Ataca: ");
            System.out.println(enemigo.getNombre());
            enemigo.doCombo(personaje);
            Jugador.getInstance().partida.getJuego().notificaciones.getItems().add("La vida de Gokú es " + Jugador.getInstance().getVida());
        } else {
            personaje.robarHabilidad(enemigo);
            Jugador.getInstance().partida.getJuego().notificaciones.getItems().add(enemigo.getNombre() + " ha muerto, Gokú ganó!");
            peleando = false;
            Jugador.getInstance().partida.getJuego().getPersonajeEnemigo().setVisible(false);
        }

    }


    @Override
    public void satisfacer() {
        atacar();
    }
}
