package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;
import ModuloPelea.ModuloPersonajes.Jugador;

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
        Jugador.getInstance().velocidad = 55;
        Jugador.getInstance().controladorSalud.modSaludSocial(-25);
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(25);
    }

    public Ansiedad(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted,
                    int satisfaccionSuennoMenor, int saludSocialMenor) {
        super(posiblesMedicamentos, tipo, accepted);
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
