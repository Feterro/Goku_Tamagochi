import LibreriaPersonajes.TDA.Personaje;
import Model.ControladorSalud;
import ModuloPelea.ModuloPersonajes.EnemigoFactory;
import ModuloPelea.ModuloPersonajes.Jugador;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.*;

import java.util.ArrayList;

public class MainPruebas {

    public static void main(String[] args){

        new EnemigoFactory();//Fabrica de personajes
        new HabilidadFactory();//Fabrica de armas
        Jugador personaje = new Jugador(new Personaje.BuilderPersonaje().setNombre("Goku").addApariencia("Goku.jpg").setVida(500).addArma(HabilidadFactory.getHabilidad("Karate")).build());

        Jugador.getInstance().setControladorSalud(new ControladorSalud());
        Jugador.getInstance().initializeControllers();

        System.out.println(Jugador.getInstance().controladorSalud.getSaludSocial());
        System.out.println(Jugador.getInstance().controladorSalud.getSaludFisica());
        System.out.println(Jugador.getInstance().controladorSalud.getLiquidosConsumidos());
        System.out.println(Jugador.getInstance().controladorSalud.getSatisfaccionHambre());
        System.out.println(Jugador.getInstance().controladorSalud.getSatisfaccionBano());
        System.out.println(Jugador.getInstance().controladorSalud.getSolidosConsumidos());
        System.out.println(Jugador.getInstance().controladorSalud.getSatisfaccionSuenno());
        System.out.println(Jugador.getInstance().controladorSalud.getProbabilidadEnfermedad());

        Jugador.getInstance().controladores.get(EnumActividades.Comer).satisfacer();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(Jugador.getInstance().controladorSalud.getSaludSocial());
        System.out.println(Jugador.getInstance().controladorSalud.getSaludFisica());
        System.out.println(Jugador.getInstance().controladorSalud.getLiquidosConsumidos());
        System.out.println(Jugador.getInstance().controladorSalud.getSatisfaccionHambre());
        System.out.println(Jugador.getInstance().controladorSalud.getSatisfaccionBano());
        System.out.println(Jugador.getInstance().controladorSalud.getSolidosConsumidos());
        System.out.println(Jugador.getInstance().controladorSalud.getSatisfaccionSuenno());
        System.out.println(Jugador.getInstance().controladorSalud.getProbabilidadEnfermedad());
    }

}
