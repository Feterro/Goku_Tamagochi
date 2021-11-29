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
        ArrayList<Arma> armas2 = new ArrayList<Arma>(); armas2.add(HabilidadFactory.getInstance().getHabilidad("Kame hame ha"));

        deportes.add(new Futbol(15, EnumDeportes.FUTBOL, armas, "src/VISTA/Imagenes/Deportes/soccer.png"));
        deportes.add(new Karate(10, EnumDeportes.KARATE, armas2, "src/VISTA/Imagenes/Deportes/boxeo.png"));
        ProcesadorSerializable.fileWriter(deportes,PATH);
    }

    public static ArrayList<Deporte> loadDeportes(){
        return (ArrayList<Deporte>) ProcesadorSerializable.fileReader(PATH);
    }
}
