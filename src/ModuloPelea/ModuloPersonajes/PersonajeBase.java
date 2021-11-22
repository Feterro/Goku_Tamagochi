package ModuloPersonajes;

import java.util.ArrayList;

public class PersonajeBase{

    protected ArrayList<Habilidad> habilidades = new ArrayList<>();//Son las armas de los personajes base.
    protected int vida;
    protected int nivel;
    protected String imagen;
    protected String name;

    public String getName(){
        return name;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void agregarHabilidad(Habilidad habilidad){
        habilidades.add(habilidad);
    }

}