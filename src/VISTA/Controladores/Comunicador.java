package VISTA.Controladores;

public class Comunicador {

    private static Comunicador comunicador;

    public Comunicador() {}
    
    public static Comunicador getInstance(){
        if (comunicador == null){
            comunicador = new Comunicador();
        }
        return comunicador;
    }
}
