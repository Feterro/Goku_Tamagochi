package FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcesadorSerializable {

    public ProcesadorSerializable() {}

    public static void fileWriter(Object object, String path) {

        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Database saved successfully at: " + path);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object fileReader(String path) {
        Object readObject;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            readObject = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Loaded DataBase successfully from: " + path);
            return readObject;
        }catch (FileNotFoundException e){
            System.out.println("No hay archivo");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("File not found");
            c.printStackTrace();
        }
        return null;
    }

}