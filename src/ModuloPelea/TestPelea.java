import ModuloHabilidades.Karate;
import ModuloPersonajes.Enemigo;
import ModuloPersonajes.EnemyFactory;
import ModuloPersonajes.Pelea;
import ModuloPersonajes.Personaje;

public class TestPelea {
    public static void main(String[] args) throws Exception {

        new EnemyFactory();
        Personaje personaje = new Personaje("Goku",500);
        personaje.agregarHabilidad(new Karate());//Esto podria hacerse desde una fabrica de habilidades. Se obtineen del ejercicio
        Pelea pelea = new Pelea(personaje);
        pelea.addToCombo(personaje.getHabilidad(0));
        pelea.addToCombo(personaje.getHabilidad(0));
        pelea.addToCombo(personaje.getHabilidad(0));
        pelea.atacar();
        pelea.addToCombo(personaje.getHabilidad(0));
        pelea.addToCombo(personaje.getHabilidad(0));
        pelea.atacar();
    }
}