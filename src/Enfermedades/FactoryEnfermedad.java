package Enfermedades;

import java.util.concurrent.ThreadLocalRandom;

public class FactoryEnfermedad {

    public static AbstractEnfermedad getEnfermedad(EnumTipoEnfermedad enfermedad){
        switch (enfermedad){
            case DIARREA:
                return new Diarrea();
            case ANSIEDAD:
                return new Ansiedad();
            case CALAMBRE:
                return new Calambre();
            case ESGUINCE:
                return new Esguince();
            default:
                return new Diarrea();
        }
    }

    public static AbstractEnfermedad getRandomAssEnfermedad(){
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        switch (random){
            case 1:
                return new Diarrea();
            case 2:
                return new Ansiedad();
            case 3:
                return new Calambre();
            case 4:
                return new Esguince();
            default:
                return new Diarrea();
        }
    }

}
