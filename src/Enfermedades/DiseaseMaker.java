package Enfermedades;

import Consumibles.EnumMedicamento;
import FileManager.ProcesadorSerializable;

import java.util.ArrayList;

public class DiseaseMaker {
    static final String PATH = "src\\Utils\\Enfermedades.txt";

    public static void saveEnfermedades(){
        ArrayList<AbstractEnfermedad> enfermedades = new ArrayList<>();

        //Params ansiedad: ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted, boolean active,
        //                 int satisfaccionSuennoMenor, int saludSocialMenor
        ArrayList<EnumMedicamento> meds = new ArrayList<>(); meds.add(EnumMedicamento.ESTILO);
        ArrayList<EnumMedicamento> meds2 = new ArrayList<>(); meds.add(EnumMedicamento.PEPTO_BISMOL);
        enfermedades.add(new Ansiedad(meds,EnumTipoEnfermedad.ANSIEDAD,false,45,45));
        enfermedades.add(new Diarrea(meds,EnumTipoEnfermedad.ANSIEDAD,false,85,90));
        ProcesadorSerializable.fileWriter(enfermedades,PATH);
    }

    public static ArrayList<AbstractEnfermedad> loadEnfermedades(){
        return (ArrayList<AbstractEnfermedad>) ProcesadorSerializable.fileReader(PATH);
    }
}
