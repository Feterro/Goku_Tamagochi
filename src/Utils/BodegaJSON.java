package Utils;

import Consumibles.*;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BodegaJSON implements Serializable{
    private static BodegaJSON instance;
    private String URL;
    private final Gson json;
    private ObjFormat data;

    private BodegaJSON() throws IOException {
        this.URL = "src\\Utils\\Bodega.json";
        this.json = new Gson();
        data = new ObjFormat();
        this.readJSON();
    }

    public static BodegaJSON getInstance() throws IOException{
        if(BodegaJSON.instance != null){
            return BodegaJSON.instance;
        }
        BodegaJSON.instance = new BodegaJSON();
        return instance;
    }

    private class ObjFormat implements Serializable{
        public ArrayList<Alimento> alimentos= new ArrayList();
        public ArrayList<Medicamento> medicamentos = new ArrayList();
    }

    private void readJSON() throws FileNotFoundException, IOException {
        try {
            if(new File(this.URL).exists()){
                InputStream is = new FileInputStream(this.URL);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                ObjFormat data = json.fromJson(bufferedReader, ObjFormat.class);
                if (data !=  null){
                    this.data = data;
                }
                bufferedReader.close();
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Alimento> getAlimentos(){ return this.data.alimentos;}

    public ArrayList<Medicamento> getMedicamentos(){return this.data.medicamentos;}


    public HashMap<EnumAlimento,Consumible>  getHashMapAlimentos(){
        HashMap<EnumAlimento,Consumible> alimentos = new HashMap();
        for (Alimento alimento: getAlimentos()){
            alimentos.put(alimento.getNombre(), alimento);
        }
        return alimentos;
    }

    public HashMap<EnumMedicamento,Consumible> getHashMapMedicamentos(){
        HashMap<EnumMedicamento,Consumible> medicamentos = new HashMap();
        for (Medicamento medicamento: getMedicamentos()){
            medicamentos.put(medicamento.getNombre(), medicamento);
        }
        return medicamentos;
    }


    public void updateJSON() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.URL)));
            writer.write("");
            writer.write("{\"alimentos\":");
            writer.write(json.toJson(getAlimentos()));
            writer.write(",\"medicamentos\":");
            writer.write(json.toJson(getMedicamentos()));
            writer.write("}");
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }


}