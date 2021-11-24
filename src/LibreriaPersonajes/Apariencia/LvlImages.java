package LibreriaPersonajes.Apariencia;

import LibreriaPersonajes.PrototypePattern.IPrototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Esta clase es adicional puede quitarse luego. Lo que hace es que guarda una lista de imagenes que corresponden a un nivel.
//La guarda en un hash para que por un key se pueda buscar el tipo de accion de imagenes que se quiere ver. Ejemplo "Enojado" con la lista de imagenes 0-1 todo esto correspondiendo a un nivel.
//Otro ejemplo es el "Caminando" con su respectico ArrayList de URls caminando
public class LvlImages implements IPrototype<LvlImages> {

    private static final long serialVersionUID = -5460219658652083079L;

    HashMap<String,String> aparienciasPorNivel;

    public LvlImages(){
        this.aparienciasPorNivel = new HashMap<String,String>();
    }


    public LvlImages(String nombre,String url){
        this.aparienciasPorNivel = new HashMap<String, String>();
        this.aparienciasPorNivel.put(nombre, url);
    }

    public LvlImages(HashMap<String, String> aparienciasPorNivel) {
        this.aparienciasPorNivel = aparienciasPorNivel;
    }

    public HashMap<String,String> getAparienciasPorNivel(){
        return this.aparienciasPorNivel;
    }

    public String getAparienciasPorNivel(String key) {
        return aparienciasPorNivel.get(key);
    }

    //Creo que este cuenta a su vez como un set porque el hashmap sobreescribe en los campos del key.
    public void addApariencia(String nombre,String urls){
        this.aparienciasPorNivel.put(nombre, urls);
    }

//    @Override
//    public String toString(){
//        String string = "Apariencias:\n";
//        for (Map.Entry<String,String> apariencia : aparienciasPorNivel.entrySet()) {
//            string += apariencia.getKey()+"\t";
//            for (String url : apariencia.getValue()) {
//                string += url + " ";
//            }
//        }
//        return string;
//    }

    public String getDefault(){
        ArrayList<String> defaultImages = new ArrayList<String>(aparienciasPorNivel.values());
        return defaultImages.get(0);
    }

    //TODO:Preguntar si incluimos en interfaz un boton que deje copiar los campos de las imagenes. Con arrayList libres
    //Esto clon puede ser util para copiar el set de acciones pero que tengan imagenes nuevas. Esto puede ser util para cuando se quiere repetir
    //Las acciones pero no se quieren las mismas imagenes. Mas creacional que de copia.
    @Override
    public LvlImages clone() {
        HashMap<String,String> copiaApariencias = new HashMap<String,String>();
        for (Map.Entry<String,String> apariencia : aparienciasPorNivel.entrySet()) {
            String key = apariencia.getKey();
            String value = new String();
            copiaApariencias.put(key, value);
        }
        return new LvlImages(copiaApariencias);
    }

    @Override
    public LvlImages deepClone() {
        HashMap<String,String> copiaApariencias = new HashMap<String,String>();
        for (Map.Entry<String,String> apariencia : aparienciasPorNivel.entrySet()) {
            String key = apariencia.getKey();
            String value = new String(apariencia.getValue()); //Estoy inseguro con esta solucion
            copiaApariencias.put(key, value);
        }
        return new LvlImages(copiaApariencias);
    }

}
