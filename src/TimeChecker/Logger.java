package TimeChecker;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.jnlp.FileContents;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

public class Logger implements Serializable {
    private String filePath;
    private static JSONObject dias = new JSONObject();

    public  Logger(){

    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public static String serializarObjeto(Object object){
        // se fuarda el objeto serializado.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
//            System.out.println(byteArrayOutputStream);
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            return  Base64.getEncoder().encodeToString(byteArray);
//            return byteArrayOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static Object deserealizar(String serializado){
//
//        try {
//            ByteArrayInputStream bs= new ByteArrayInputStream(bytes); // bytes es el byte[]
//            ObjectInputStream is = new ObjectInputStream(bs);
//            Object object = (Object) is.readObject();
//            is.close();
//            return object;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    public static void guardarDia(String dia, String pathFile, String serializado){
        dias.put(dia, pathFile+dia+".txt");
        try{
            String path = pathFile+dia+".txt";
            FileWriter file = new FileWriter(pathFile+dia+".txt");
//            System.out.println();
            file.write(serializado);
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void saveJson(String path){
        try{
            FileWriter file = new FileWriter(path);
            file.write(dias.toJSONString());
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readJson(String day){
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


//    public static Object deserealizado(String filePath){
//        FileInputStream file = null;
//
//        Object object;
//
//        try{
//            System.out.println(1);
//            System.out.println(filePath);
////            file = new FileInputStream(filePath);
//            String text = readFile(filePath);
//
//            System.out.println(2);
//            Logger obj = (Logger) convertFromByteString(text);
//            System.out.println(obj.filePath);
//            ObjectInputStream entrada = new ObjectInputStream(file);
//            System.out.println(3);
//            object = (Object) entrada.readObject();
//            return object;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static Object deserealizar(String byteString) throws IOException, ClassNotFoundException {
        final byte[] bytes = Base64.getDecoder().decode(byteString);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

    public static String readFile(String fileName){
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

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setFilePath("Prueba.txt");
        String serializado = serializarObjeto(logger);
        guardarDia("1", "src/TimeChecker/Dias/", serializado);
        saveJson("src/TimeChecker/Dias/dias.json");
//        System.out.println(bytes);
//        System.out.println("IHOLH");
//        System.out.println(((Logger)deserealizarObjeto(bytes.toByteArray())).filePath);
        String dia =  readJson("1");
//        System.out.println(dia);
        String texto = readFile(dia);
        try {
            Logger logger1 = (Logger)deserealizar(texto);
            System.out.println(logger1.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println("SI"+byytes);
//        ByteArrayOutputStream bytees = parseToByteArray(byytes);
//        System.out.println("FIN");
//        System.out.println(byytes.getBytes());
//        System.out.println((Logger)deserealizarObjeto(byytes));
    }

}
