package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Enemigo extends Personaje {

    private static final long serialVersionUID = 7L;


    public Enemigo(Personaje personaje){//El nivel de los enemigos tiene que estar cerca del nivel de goku
        super(personaje);
    }

    

    private ArrayList<Arma> crearCombo(){
        ArrayList<Arma> combo = new ArrayList<>();
        String key = (String) armas.getArmas().keySet().stream().toArray()[ThreadLocalRandom.current().nextInt(0, armas.getArmas().size())];
        for(int i = 0;i<3;i++){
            combo.add(armas.getArmas().get(key));
        }
        return combo;
    }

    public void doCombo(Jugador personaje){
        ArrayList<Personaje> objetivos = new ArrayList<>();
        objetivos.add(personaje);
        atacar(objetivos,crearCombo());
    }

    public ArrayList<Arma> getHabilidades(){
        return new ArrayList<>(armas.getArmas().values());
    }

    public Enemigo deepClone(){
        return  new Enemigo(new BuilderPersonaje().setNombre(this.nombre).setApariencia(this.apariencia).setVida(this.vida).build());
    }
    
}
