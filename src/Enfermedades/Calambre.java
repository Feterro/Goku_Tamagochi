package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.Jugador;

import java.util.ArrayList;

public class Calambre  extends AbstractEnfermedad{

    private static final long serialVersionUID = 44002L;

    private int saludFisicaMenor;


    public Calambre() {
        //Si los valores menor a esto, le da un calambre
        //Agregar algo mas
        this.saludFisicaMenor = 42;
    }

    @Override
    public void afectar() {
        Jugador.getInstance().velocidad = 30;
        Jugador.getInstance().controladorSalud.modSaludFisica(-30);
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(-10);
    }

    public Calambre(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted,
                    int saludFisicaMenor, int probEnfermedadMenor) {
        super(posiblesMedicamentos, tipo, accepted);
        this.saludFisicaMenor = saludFisicaMenor;


    }

    public int getSaludFisicaMenor() {
        return saludFisicaMenor;
    }

    public void setSaludFisicaMenor(int saludFisicaMenor) {
        this.saludFisicaMenor = saludFisicaMenor;
    }


}
