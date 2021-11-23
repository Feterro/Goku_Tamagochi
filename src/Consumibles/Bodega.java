package Consumibles;

import java.util.HashMap;

public class Bodega {

    private HashMap<EnumAlimento,Consumible> alimentos = new HashMap<>();
    private HashMap<EnumMedicamento,Consumible> medicamentos = new HashMap<>();

    public void addAlimento(EnumAlimento name, Consumible consumible){
        alimentos.put(name, consumible);
    }

    public void addMedicamentos(EnumMedicamento name, Consumible consumible){
        medicamentos.put(name, consumible);
    }
}
