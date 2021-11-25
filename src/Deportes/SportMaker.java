package Deportes;

import Consumibles.EnumMedicamento;
import Enfermedades.AbstractEnfermedad;
import Enfermedades.Ansiedad;
import Enfermedades.Diarrea;
import Enfermedades.EnumTipoEnfermedad;
import FileManager.ProcesadorSerializable;
import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;

import java.util.ArrayList;

public class SportMaker {
    static final String PATH = "src\\Utils\\Deportes.txt";

    public static void saveDeportes(){
        ArrayList<Deporte> deportes = new ArrayList<>();
        ArrayList<Arma> armas = new ArrayList<Arma>(); armas.add(HabilidadFactory.getInstance().getHabilidad("Patada Alta"));
        ArrayList<Arma> armas2 = new ArrayList<Arma>(); armas.add(HabilidadFactory.getInstance().getHabilidad("Karate"));

        deportes.add(new Futbol(20,30,15,EnumDeportes.FUTBOL,armas));
        deportes.add(new Karate(22,35,10,EnumDeportes.KARATE,armas2));
        ProcesadorSerializable.fileWriter(deportes,PATH);
    }

    public static ArrayList<Deporte> loadDeportes(){
        return (ArrayList<Deporte>) ProcesadorSerializable.fileReader(PATH);
    }
}
