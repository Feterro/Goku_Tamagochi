package ModuloPelea.CreadorDeEnemigos;

import Enfermedades.AbstractEnfermedad;
import Enfermedades.Ansiedad;
import FileManager.ProcesadorSerializable;
import LibreriaPersonajes.Apariencia.LvlImages;
import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.Enemigo;

import java.util.ArrayList;

public class EnemyMaker {
    static final String PATH = "src\\Files\\EnemyList.txt";

    public static void saveEnemyList(){

        ArrayList<Personaje> enemigos = new ArrayList<>();
        LvlImages cosas = new LvlImages();
        cosas.addApariencia("default", "src/VISTA/Imagenes/Enemigo/enemigo1.png");
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(300).setNombre("Broly").addApariencia(0, cosas).build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(275).setNombre("Bu").addApariencia(0, cosas).build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(50).setNombre("Saibaman").addApariencia(0, cosas).build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(150).setNombre("Cell").addApariencia(0, cosas).build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(200).setNombre("Freezer").addApariencia(0, cosas).build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(220).setNombre("Trunks").addApariencia(0, cosas).build()));

        ProcesadorSerializable.fileWriter(enemigos,PATH);
    }

    public static ArrayList<Enemigo> loadAbilityList(){
        return (ArrayList<Enemigo>) ProcesadorSerializable.fileReader(PATH);
    }

}
