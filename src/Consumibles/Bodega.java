package Consumibles;

import Utils.BodegaJSON;

import java.io.IOException;
import java.util.ArrayList;
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

    public Alimento getAlimento(EnumAlimento alimento) {
        return (Alimento) alimentos.get(alimento);
    }

    public Medicamento getMedicamento(EnumMedicamento medicamento) {
        return (Medicamento) medicamentos.get(medicamento);
    }

    public ArrayList<String> getAlimentosDisponibles(){
        ArrayList<String> disponibles = new ArrayList<>();
        for(EnumAlimento item : alimentos.keySet()){
            if(alimentos.get(item).cantidadDisponible > 0)
                disponibles.add(item.toString());
        }
        return disponibles;
    }

    public ArrayList<String> getMedicamentosDisponibles(){
        ArrayList<String> disponibles = new ArrayList<>();
        for(EnumMedicamento item : medicamentos.keySet()){
            if(medicamentos.get(item).cantidadDisponible > 0)
                disponibles.add(item.toString());
        }
        return disponibles;
    }
}
