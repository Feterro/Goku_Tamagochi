package Consumibles;

import Utils.BodegaJSON;

import java.io.IOException;
import java.util.HashMap;

public class Bodega {

    private HashMap<EnumAlimento,Consumible> alimentos;
    private HashMap<EnumMedicamento,Consumible> medicamentos;
    private BodegaJSON bodegaJson;
    public static Bodega bodega;

    private Bodega() throws IOException {
        this.bodegaJson= BodegaJSON.getInstance();
        this.alimentos = bodegaJson.getHashMapAlimentos();
        this.medicamentos = bodegaJson.getHashMapMedicamentos();
    }

    public static Bodega getInstance() throws IOException {
        if (bodega == null)
            bodega = new Bodega();
        return bodega;
    }

    public void addAlimento(EnumAlimento name, Consumible consumible){
        alimentos.put(name, consumible);
    }

    public void addMedicamentos(EnumMedicamento name, Consumible consumible){
        medicamentos.put(name, consumible);
    }

    public HashMap<EnumAlimento, Consumible> getAlimentos() {return alimentos;}

    public HashMap<EnumMedicamento, Consumible> getMedicamentos() {return medicamentos;}
}
