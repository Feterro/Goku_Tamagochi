import Utils.BodegaJSON;
import Utils.EnfermedadJSON;

import java.io.IOException;
import java.util.ArrayList;

public class MainPruebas {

    public static void main(String[] args) throws IOException {

        System.out.println("Puto quien lo lea");
        BodegaJSON b = BodegaJSON.getInstance();
        System.out.println(b.getHashMapAlimentos());
        //EnfermedadJSON e = EnfermedadJSON.getInstance();

    }

}
