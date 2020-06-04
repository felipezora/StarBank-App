package json;

import com.google.gson.*;
import sample.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serializador {

    public static void anadirJson(Object obj, String archivo) {
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

    public static void serializarCuenta(Cuenta[] cuentas, String archivo){}

    public static ClientePersona[] deserializarClientePersona(String archivo) {
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

        ClientePersona[] objetos = gson.fromJson(json, ClientePersona[].class);
        return objetos;
    }

    public static ClienteEmpresa[] deserializarClienteEmpresa(String archivo) {
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

        ClienteEmpresa[] objetos = gson.fromJson(json, ClienteEmpresa[].class);
        return objetos;
    }

    public static CuentaCorriente[] deserializarCuentaCorriente(String archivo) {
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

        CuentaCorriente[] objetos = gson.fromJson(json, CuentaCorriente[].class);
        return objetos;
    }

    public static CuentaAhorros[] deserializarCuentaAhorros(String archivo) {
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

        CuentaAhorros[] objetos = gson.fromJson(json, CuentaAhorros[].class);
        return objetos;
    }

    public static Sucursal[] deserializarSucursales(String archivo) {
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

        Sucursal[] objetos = gson.fromJson(json, Sucursal[].class);
        return objetos;
    }
}