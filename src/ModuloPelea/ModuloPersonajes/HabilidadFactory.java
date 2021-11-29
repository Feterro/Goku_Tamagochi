package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import ModuloPelea.CreadorDeHabilidades.AbilityMaker;
import java.util.HashMap;

public class HabilidadFactory {
    private static HabilidadFactory instance;
    private HashMap<String, Arma> habilidades;

    private HabilidadFactory() {
        this.habilidades =  new HashMap<>();
        llenarHashHabilidades();
    }

    public static HabilidadFactory getInstance() {
        if(HabilidadFactory.instance != null){
            return HabilidadFactory.instance;
        }
        HabilidadFactory.instance = new HabilidadFactory();
        return instance;
    }

    public void llenarHashHabilidades(){
        AbilityMaker.saveAbilityList();
        System.out.println("Se cargaron las habilidades");
        for (Arma arma: AbilityMaker.loadAbilityList()){
            this.habilidades.put(arma.getNombre(),arma);
        }
        System.out.println(habilidades);
    }

    public Arma getHabilidad(String name){
        return habilidades.get(name);
    }

    public Arma getRandomHabilidad() {
        System.out.println(habilidades);
        int R =(int) (Math.random()*habilidades.size());
        System.out.println(R + "numero");
        return habilidades.get(habilidades.keySet().toArray()[R]);
    }

}









/*
public class HabilidadFactory {

    static ArrayList<Arma> habilidades;

    public HabilidadFactory(){
        loadArmas();
    }

    private void loadArmas(){
        habilidades = AbilityMaker.loadAbilityList();
    }

    public static Arma getRandomHabilidad(){
        return habilidades.get(ThreadLocalRandom.current().nextInt(0, habilidades.size()));
    }

    public static Arma getHabilidad(String name){
        for (Arma habilidad:habilidades){
            if(habilidad.getNombre().equals(name))
                return habilidad;
        }
        return null;
    }

    public static Arma getHabilidad(int index){
        return habilidades.get(index);
    }
}
*/