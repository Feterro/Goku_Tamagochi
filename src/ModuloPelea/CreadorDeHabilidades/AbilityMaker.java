package ModuloPelea.CreadorDeHabilidades;

import FileManager.ProcesadorSerializable;
import LibreriaPersonajes.TDA.Arma;

import java.util.ArrayList;

public class AbilityMaker {

    static final String PATH = "src\\Files\\AbilityList.txt";

    public static void saveAbilityList(){ //buscar estas imagenes y agregarlas
        ArrayList<Arma> habilidades = new ArrayList<>();
        habilidades.add(new Arma.BuilderArma().setNombre("Kame hame ha").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(75).build());
        habilidades.add(new Arma.BuilderArma().setNombre("JiuJitsu").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(30).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Torpedo").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(68).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Boxing").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(30).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Patada Alta").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(54).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Rayos").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(87).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Gancho").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(42).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Mata leones").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(25).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Karate").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(20).build());
        habilidades.add(new Arma.BuilderArma().setNombre("Codazo en la nuca").addApariencia("VISTA/Imagenes/Enemigo/enemigo1.png").setDano(100).build());
        ProcesadorSerializable.fileWriter(habilidades,PATH);
    }

    public static ArrayList<Arma> loadAbilityList(){
        return (ArrayList<Arma>) ProcesadorSerializable.fileReader(PATH);
    }



}
