package TimeChecker;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Base64;

public class Logger implements Serializable {
    private String filePath;
    private static JSONObject dias = new JSONObject();
    private static final long serialVersionUID = 1003L;
    public  Logger(){

    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public String serializarObjeto(Object object){
        // se fuarda el objeto serializado.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            return  Base64.getEncoder().encodeToString(byteArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void guardarDia(int dia, int anio, String pathFile, String serializado){
        dias.put(dia+"-"+anio, pathFile+dia+"-"+anio+".txt");
        try{
            String path = pathFile+dia+".txt";
            FileWriter file = new FileWriter(pathFile+dia+"-"+anio+".txt");
            file.write(serializado);
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveJson(String path){
        try{
            FileWriter file = new FileWriter(path);
            file.write(dias.toJSONString());
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String readJson(String day){
        JSONParser jsonParser = new JSONParser();
        try{

            FileReader fileReader = new FileReader("src/TimeChecker/Dias/dias.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            String dia = jsonObject.get(day).toString();

            return dia;

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public Object deserealizar(String byteString) throws IOException, ClassNotFoundException {
        final byte[] bytes = Base64.getDecoder().decode(byteString);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

    public String readFile(String fileName){
        try{
            FileReader fileReader = new FileReader(fileName);
            int caracterLeido = fileReader.read();
            String texto = "";
            while(caracterLeido!= -1) {
                char caracter = (char) caracterLeido;
                texto += caracter;
                caracterLeido = fileReader.read();
            }
            return texto;

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Partida buscarPartida(String dia){
        String filePath = readJson(dia);
        String texto = readFile(filePath);
        try {
            Partida partida = (Partida) deserealizar(texto);
            return partida;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Logger logger = new Logger();
//        logger.setFilePath("Prueba.txt");
//        String serializado = serializarObjeto(logger);
//        guardarDia("1", "src/TimeChecker/Dias/", serializado);
//        saveJson("src/TimeChecker/Dias/dias.json");
////        System.out.println(bytes);
////        System.out.println("IHOLH");
////        System.out.println(((Logger)deserealizarObjeto(bytes.toByteArray())).filePath);
//        String dia =  readJson("1");
////        System.out.println(dia);
//        String texto = readFile(dia);
//        try {
//            Logger logger1 = (Logger)deserealizar(texto);
//            System.out.println(logger1.filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
////        System.out.println("SI"+byytes);
////        ByteArrayOutputStream bytees = parseToByteArray(byytes);
////        System.out.println("FIN");
////        System.out.println(byytes.getBytes());
////        System.out.println((Logger)deserealizarObjeto(byytes));
//    }

}
