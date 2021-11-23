package ModuloPelea;

import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.EnemigoFactory;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;
import ModuloPelea.ModuloPersonajes.Pelea;
import ModuloPelea.ModuloPersonajes.Goku;

public class TestPelea {
    public static void main(String[] args) throws Exception {

        new EnemigoFactory();//Fabrica de personajes
        new HabilidadFactory();//Fabrica de armas
        Goku personaje = new Goku(new Personaje.BuilderPersonaje().setNombre("Goku").addApariencia("Goku.jpg").setVida(500).addArma(HabilidadFactory.getHabilidad("Karate")).build());
        Pelea pelea = new Pelea(personaje);
        pelea.addToCombo(personaje.getHabilidad("Karate"));
        pelea.addToCombo(personaje.getHabilidad("Karate"));
        pelea.addToCombo(personaje.getHabilidad("Karate"));
        pelea.atacar();
        pelea.addToCombo(personaje.getHabilidad("Karate"));
        pelea.addToCombo(personaje.getHabilidad("Karate"));
        pelea.atacar();
    }
}