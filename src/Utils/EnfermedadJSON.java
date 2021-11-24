package Utils;

import Consumibles.*;
import Enfermedades.AbstractEnfermedad;
import Enfermedades.EnumTipoEnfermedad;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EnfermedadJSON {
    private static EnfermedadJSON instance;
    private String URL;
    private final Gson json;
    private ObjFormat data;

    private EnfermedadJSON() throws IOException {
        this.URL = "src\\Utils\\Enfermedad.json";
        this.json = new Gson();
        data = new ObjFormat();
        this.readJSON();
    }

    public static EnfermedadJSON getInstance() throws IOException{
        if(EnfermedadJSON.instance != null){
            return EnfermedadJSON.instance;
        }
        EnfermedadJSON.instance = new EnfermedadJSON();
        return instance;
    }

    private class ObjFormat{
        public ArrayList<AbstractEnfermedad> enfermedades= new ArrayList();
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

    public ArrayList<AbstractEnfermedad> getEnfermedades(){ return this.data.enfermedades;}


    public HashMap<EnumTipoEnfermedad,AbstractEnfermedad> getHashMapMedicamentos(){
        HashMap<EnumTipoEnfermedad,AbstractEnfermedad> enfermedades = new HashMap();
        for (AbstractEnfermedad enfermedad: getEnfermedades()){
            enfermedades.put(enfermedad.getTipo(), enfermedad);
        }
        return enfermedades;
    }


}