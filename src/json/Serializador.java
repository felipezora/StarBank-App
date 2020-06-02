package json;

import com.google.gson.*;
import sample.ClienteEmpresa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serializador {

    public static void serializar(Object obj, String archivo) {
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Object[] objetos = gson.fromJson(json, Object[].class);
        json = "[";
        if(objetos!=null){
            for(Object recorrido: objetos){
                json += gson.toJson(recorrido) + ",";
            }
        }

        json += gson.toJson(obj) + "]";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(json);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void registrarOpClienteEmpresa() {
    }
}