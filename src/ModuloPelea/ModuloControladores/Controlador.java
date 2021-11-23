package ModuloPelea.ModuloControladores;

public abstract class Controlador {

    public abstract void satisfacer();
    public abstract void negar();

    public void setValor(Object object){
        //Hace override en quien lo necesite. No se que tan SOLID sea
    }

}
