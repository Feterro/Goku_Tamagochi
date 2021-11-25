package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;
import ModuloPelea.ModuloPersonajes.Jugador;

import java.util.ArrayList;

public class Esguince  extends AbstractEnfermedad{
    //No sé como saber cuando le dio un Esguince a menos que sea provocado por un deporte
    private int saludFisicaMenor;

    public Esguince() {
        this.saludFisicaMenor = 30;
    }

    @Override
    public void afectar() {

        Jugador.getInstance().velocidad = 45;
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);
        Jugador.getInstance().controladorSalud.modSaludSocial(-15);
    }

    public Esguince(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted,
                    int saludFisicaMenor) {
        super(posiblesMedicamentos, tipo, accepted);
        this.saludFisicaMenor = saludFisicaMenor;
    }


}
