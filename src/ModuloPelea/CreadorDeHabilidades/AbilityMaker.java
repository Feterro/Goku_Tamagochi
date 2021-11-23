package ModuloPelea.CreadorDeHabilidades;

import FileManager.ProcesadorSerializable;
import LibreriaPersonajes.TDA.Arma;

import java.util.ArrayList;

public class AbilityMaker {

    static final String PATH = "src\\Files\\AbilityList.txt";

    public static void saveAbilityList(){
        ArrayList<Arma> habilidades = new ArrayList<>();
        habilidades.add(new Arma.BuilderArma().setNombre("Kamehameha").addApariencia("Kamehameha.jpg").setDano(75).build());
        habilidades.add(new Arma.BuilderArma().setNombre("JiuJitsu").addApariencia("JiuJitsu.jpg").setDano(30).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Torpedo").addApariencia("Torpedo.jpg").setDano(68).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Boxing").addApariencia("Boxing.jpg").setDano(30).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Patada Alta").addApariencia("Patada_Alta.jpg").setDano(54).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Rayos").addApariencia("Rayos.jpg").setDano(87).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Gancho").addApariencia("Gancho.jpg").setDano(42).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Mata leones").addApariencia("Mata_leones.jpg").setDano(25).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Karate").addApariencia("Karate.jpg").setDano(20).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Codazo en la nuca").addApariencia("Codazo_en_la_nuca.jpg").setDano(100).build());
        ProcesadorSerializable.fileWriter(habilidades,PATH);
    }

    public static ArrayList<Arma> loadAbilityList(){
        return (ArrayList<Arma>) ProcesadorSerializable.fileReader(PATH);
    }



}
