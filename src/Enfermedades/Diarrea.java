package Enfermedades;

import Consumibles.EnumMedicamento;
import Consumibles.Medicamento;

import java.util.ArrayList;

public class Diarrea  extends AbstractEnfermedad{
    //Ver si estos los tendrá el personaje por el controllerSalud no los tiene
    private int nivelComidaInjeridaMayor;
    private int energiaMayor;

    public Diarrea() {
        //Cuando tiene mucha energia y comió mucho, le da hambre
        this.nivelComidaInjeridaMayor = 85;
        this.energiaMayor = 90;
    }

    @Override
    public void afectar() {
        System.out.println("Afectar xd");
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
