package Deportes;

import Enfermedades.*;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class SportFactory {
    private static SportFactory instance;
    private HashMap<EnumDeportes, Deporte> deportes;

    private SportFactory() {
        this.deportes =  new HashMap<>();
        llenarHashDeportes();
    }

    public static SportFactory getInstance() {
        if(SportFactory.instance != null){
            return SportFactory.instance;
        }
        SportFactory.instance = new SportFactory();
        return instance;
    }

    public void llenarHashDeportes(){
        SportMaker.saveDeportes();
        System.out.println("Se cargaron los deportes");
        for (Deporte deporte: SportMaker.loadDeportes()){
            this.deportes.put(deporte.tipoDeporte,deporte);
        }
        System.out.println(deportes);
    }

    public Deporte getDeporte(EnumDeportes deporte){
        return deportes.get(deporte);
    }

    public Deporte getRandomDeporte(){
        int random = ThreadLocalRandom.current().nextInt(1, 2);
        switch (random){
            case 1:
                return deportes.get(EnumDeportes.FUTBOL);
            case 2:
                return deportes.get(EnumDeportes.KARATE);
            default:
                return deportes.get(EnumDeportes.FUTBOL);
        }
    }

}