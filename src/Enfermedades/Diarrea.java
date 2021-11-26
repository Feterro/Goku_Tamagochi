package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;
import ModuloPelea.ModuloPersonajes.Jugador;
import TimeChecker.Partida;

import java.util.ArrayList;

public class Diarrea  extends AbstractEnfermedad{
    //Ver si estos los tendrá el personaje por el controllerSalud no los tiene
    private int nivelComidaInjeridaMayor;
    private int energiaMayor;
    private static final long serialVersionUID = 44003L;


    public Diarrea() {
        //Cuando tiene mucha energia y comió mucho, le da hambre
        this.nivelComidaInjeridaMayor = 85;
        this.energiaMayor = 90;
    }

    @Override
    public void afectar() {
        Jugador.getInstance().controladorSalud.modSolidosConsumidos(30);
        Jugador.getInstance().controladorSalud.modSatisfaccionBano(-30);
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(-50);
    }

    public Diarrea(ArrayList<EnumMedicamento> posiblesMedicamentos, EnumTipoEnfermedad tipo, boolean accepted,
                   int nivelComidaInjeridaMayor, int energiaMayor) {
        super(posiblesMedicamentos, tipo, accepted);
        this.nivelComidaInjeridaMayor = nivelComidaInjeridaMayor;
        this.energiaMayor = energiaMayor;
    }

    public int getNivelComidaInjeridaMayor() {
        return nivelComidaInjeridaMayor;
    }

    public void setNivelComidaInjeridaMayor(int nivelComidaInjeridaMayor) {
        this.nivelComidaInjeridaMayor = nivelComidaInjeridaMayor;
    }

    public int getEnergiaMayor() {
        return energiaMayor;
    }

    public void setEnergiaMayor(int energiaMayor) {
        this.energiaMayor = energiaMayor;
    }

}
