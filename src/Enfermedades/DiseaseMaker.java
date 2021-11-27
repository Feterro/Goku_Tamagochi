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
        ArrayList<EnumMedicamento> meds2 = new ArrayList<>(); meds2.add(EnumMedicamento.PEPTO_BISMOL);
        ArrayList<EnumMedicamento> meds3 = new ArrayList<>(); meds3.add(EnumMedicamento.ANTIBIOTICO);
        ArrayList<EnumMedicamento> meds4 = new ArrayList<>(); meds4.add(EnumMedicamento.DIASPORAL);
//        ArrayList<EnumMedicamento> meds5 = new ArrayList<>(); meds5.add(EnumMedicamento.IBUPROFENO);
        enfermedades.add(new Ansiedad(meds,EnumTipoEnfermedad.ANSIEDAD,false,45,45));
        enfermedades.add(new Diarrea(meds2,EnumTipoEnfermedad.DIARREA,false,85,90));
        enfermedades.add(new Calambre(meds3, EnumTipoEnfermedad.CALAMBRE, false, 0, 0));
        enfermedades.add(new Calambre(meds4, EnumTipoEnfermedad.ESGUINCE, false, 0, 0));
        ProcesadorSerializable.fileWriter(enfermedades,PATH);
    }

    public static ArrayList<AbstractEnfermedad> loadEnfermedades(){
        return (ArrayList<AbstractEnfermedad>) ProcesadorSerializable.fileReader(PATH);
    }
}
