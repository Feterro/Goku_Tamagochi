package Consumibles;

import Utils.BodegaJSON;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Bodega implements Serializable {

    private HashMap<EnumAlimento,Consumible> alimentos;
    private HashMap<EnumMedicamento,Consumible> medicamentos;
    public transient BodegaJSON bodegaJson;
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

    public void addAlimento(EnumAlimento name, Consumible consumible) throws IOException {

        if (!alimentos.containsKey(name)) {
            alimentos.put(name, consumible);
            BodegaJSON.getInstance().writeJSON((Alimento)consumible);
            System.out.println("Se creó alimento de este tipo!");
        } else {
            getAlimento(name).agregar();
            System.out.println("Se agregó más alimento de este tipo!");
        }

    }

    public void addMedicamentos(EnumMedicamento name, Consumible consumible) throws IOException {

        if (!medicamentos.containsKey(name)) {
            medicamentos.put(name, consumible);
            BodegaJSON.getInstance().writeJSON((Medicamento) consumible);
            System.out.println("Se creó medicamento de este tipo!");
        } else {
            getMedicamento(name).agregar();
            System.out.println("Se agregó más medicamento de este tipo!");
        }

    }

    public HashMap<EnumAlimento, Consumible> getAlimentos() {return alimentos;}

    public HashMap<EnumMedicamento, Consumible> getMedicamentos() {return medicamentos;}

    public Alimento getAlimento(EnumAlimento alimento) {
        return (Alimento) alimentos.get(alimento);
    }

    public Medicamento getMedicamento(EnumMedicamento medicamento) {
        return (Medicamento) medicamentos.get(medicamento);
    }

    public ArrayList<EnumAlimento> getAlimentosDisponibles(){
        ArrayList<EnumAlimento> disponibles = new ArrayList<>();
        for(EnumAlimento item : alimentos.keySet()){
            if(alimentos.get(item).cantidadDisponible > 0)
                disponibles.add(item);
        }
        return disponibles;
    }

    public ArrayList<EnumMedicamento> getMedicamentosDisponibles(){
        ArrayList<EnumMedicamento> disponibles = new ArrayList<>();
        for(EnumMedicamento item : medicamentos.keySet()){
            if(medicamentos.get(item).cantidadDisponible > 0)
                disponibles.add(item);
        }
        return disponibles;
    }


    /**
     * Actualiza toda la bodegacada vez que se haga un cambio.
     * Llamar despues de hacerle cualquier cambio a un alimento o medicamento si se quiere actualizar inmediatamente
     * @throws IOException
     */
    public void actualizarBodega() throws IOException {
        bodegaJson.updateJSON();
    }

    public void llenarBodega(){
        for(Consumible item : alimentos.values()){
            item.agregar();
            item.agregar();
            item.agregar();
        }
    }


}
