package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;

import java.util.ArrayList;

public class Ansiedad extends AbstractEnfermedad{
    //Si los atributos de salud menores a esto, le da amnsiedad
    public int satisfaccionSuennoMenor;
    public int saludSocialMenor;

    public Ansiedad() {
        this.satisfaccionSuennoMenor = 50;
        this.saludSocialMenor = 45;
    }

    @Override
    public void afectar() {
        System.out.println("Afectar xd");
    }

    public Ansiedad(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted, boolean active,
                    int satisfaccionSuennoMenor, int saludSocialMenor) {
        super(posiblesMedicamentos, tipo, accepted, active);
        this.satisfaccionSuennoMenor = satisfaccionSuennoMenor;
        this.saludSocialMenor = saludSocialMenor;
    }

    public int getSatisfaccionSuennoMenor() {
        return satisfaccionSuennoMenor;
    }

    public void setSatisfaccionSuennoMenor(int satisfaccionSuennoMenor) {
        this.satisfaccionSuennoMenor = satisfaccionSuennoMenor;
    }

    public int getSaludSocialMenor() {
        return saludSocialMenor;
    }

    public void setSaludSocialMenor(int saludSocialMenor) {
        this.saludSocialMenor = saludSocialMenor;
    }

}
