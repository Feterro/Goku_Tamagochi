package ModuloPelea.CreadorDeEnemigos;

import Enfermedades.AbstractEnfermedad;
import Enfermedades.Ansiedad;
import FileManager.ProcesadorSerializable;
import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.Enemigo;

import java.util.ArrayList;

public class EnemyMaker {
    static final String PATH = "src\\Files\\EnemyList.txt";

    public static void saveEnemyList(){

        ArrayList<Personaje> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(300).setNombre("Broly").addApariencia("Broly.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(275).setNombre("Bu").addApariencia("Bu.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(50).setNombre("Saibaman").addApariencia("Saibaman.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(150).setNombre("Cell").addApariencia("Cell.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(200).setNombre("Freezer").addApariencia("Freezer.jpg").build()));
        enemigos.add(new Enemigo(new Personaje.BuilderPersonaje().setVida(220).setNombre("Trunks").addApariencia("Trunks.jpg").build()));

        ProcesadorSerializable.fileWriter(enemigos,PATH);
    }

    public static ArrayList<Enemigo> loadAbilityList(){
        return (ArrayList<Enemigo>) ProcesadorSerializable.fileReader(PATH);
    }

}
