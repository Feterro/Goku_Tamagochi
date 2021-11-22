package ModuloPelea;

import ModuloPelea.ModuloHabilidades.Karate;
import ModuloPelea.ModuloPersonajes.EnemigoFactory;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;
import ModuloPelea.ModuloPersonajes.Pelea;
import ModuloPelea.ModuloPersonajes.Personaje;

public class TestPelea {
    public static void main(String[] args) throws Exception {

        new EnemigoFactory();//Fabrica de personajes
        new HabilidadFactory();//Fabrica de armas
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