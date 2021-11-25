package Enfermedades;

import Deportes.Deporte;
import Deportes.EnumDeportes;
import Deportes.SportFactory;
import Deportes.SportMaker;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class DiseaseFactory {
    private static DiseaseFactory instance;
    private HashMap<EnumTipoEnfermedad, AbstractEnfermedad> enfermedades;

    private DiseaseFactory() {
        this.enfermedades = new HashMap<>();
        llenarHashEnfermedades();
    }

    public static DiseaseFactory getInstance() {
        if(DiseaseFactory.instance != null){
            return DiseaseFactory.instance;
        }
        DiseaseFactory.instance = new DiseaseFactory();
        return instance;
    }

    public void llenarHashEnfermedades(){
        DiseaseMaker.saveEnfermedades();
        System.out.println("Enfermedades cargadas");
        for (AbstractEnfermedad enfermedad: DiseaseMaker.loadEnfermedades()){
            this.enfermedades.put(enfermedad.getTipo(),enfermedad);
        }
        System.out.println(this.enfermedades);
    }

    public AbstractEnfermedad getEnfermedad(EnumTipoEnfermedad enfermedad){
        return enfermedades.get(enfermedad);
    }


    public AbstractEnfermedad getRandomEnfermedad(){
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        switch (random){
            case 1:
                return enfermedades.get(EnumTipoEnfermedad.DIARREA);
            case 2:
                return enfermedades.get(EnumTipoEnfermedad.ANSIEDAD);
            case 3:
                return enfermedades.get(EnumTipoEnfermedad.CALAMBRE);
            case 4:
                return enfermedades.get(EnumTipoEnfermedad.ESGUINCE);
            default:
                return enfermedades.get(EnumTipoEnfermedad.DIARREA);
        }
    }

}
