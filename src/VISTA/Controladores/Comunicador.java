package VISTA.Controladores;

import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.EnumActividades;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Comunicador {

    private static Comunicador comunicador;

    public Comunicador() {}
    
    public static Comunicador getInstance(){
        if (comunicador == null){
            comunicador = new Comunicador();
        }
        return comunicador;
    }

    public Image cambiarImagenGoku(EnumActividades actividad) throws FileNotFoundException {
        InputStream stream;
        switch (actividad){
            case Comer:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Comer.name()));
                break;
            case Mimir:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Mimir.name()));
                break;
            case Ejercitar:
            case Deporte:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Ejercitar.name()));
                break;
            case Enfermo:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Enfermo.name()));
                break;
            case Caminando:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Caminando.name()));
                break;
            case Atacar:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Atacar.name()));
                break;
            case Normal:
            case Bano:
            case Cura:
            case Social:
            default:
                stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Normal.name()));
                break;
        }
        return new Image(stream);
    }
}
