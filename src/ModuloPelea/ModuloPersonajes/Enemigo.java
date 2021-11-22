package ModuloPersonajes;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Enemigo extends PersonajeBase{

    public Enemigo(String name,String imagen,int vida){//El nivel de los enemigos tiene que estar cerca del nivel de goku
        this.name = name;
        this.vida = vida;
        this.imagen = imagen;
    }

    

    private ArrayList<Habilidad> crearCombo(){
        ArrayList<Habilidad> combo = new ArrayList<>();
        for(int i = 0;i<3;i++){
            combo.add(habilidades.get(ThreadLocalRandom.current().nextInt(0, habilidades.size())));
        }
        return combo;
    }

    public void doCombo(Personaje personaje){
        for(Habilidad habilidad:crearCombo()){
            habilidad.doSomething(personaje);
        }
    }

    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    public Enemigo deepClone(){
        return new Enemigo(this.name,this.imagen,this.vida);
    }
    
}
