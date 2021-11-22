package ModuloPelea.ModuloPersonajes;

public class Habilidad {//Es el arma
    
    protected String name;
    protected String image;
    protected int damage;

    public String getName(){
        return name;
    }

    public void doSomething(PersonajeBase personaje){
        System.out.println(name + " a " + personaje.getName());
        System.out.println("Image:" + image);
    }
}
