package sample;

import json.Buscador;
import json.Serializador;

public class Cajero {

    private static Sucursal sucursalOrigen;

    public static void crearClienteEmpresa (String doc, String nombre, String telefono, String ocupacion, String direccion, String nit, String nombreEmpresa, String sectorComercial){
        //Verifica si el doc del cliente a crear no coincide con el doc de algún otro cliente ya creado en el json correspondiente al tipo de cliente. Si esto se cumple:

        ClienteEmpresa clienteNuevo = new ClienteEmpresa(doc, nombre, telefono, ocupacion, direccion, nit, nombreEmpresa, sectorComercial);
        Serializador.anadirJson(clienteNuevo, "registro_clientes_empresa.json");
    }

    public static void crearClientePersona (String doc, String nombre, String telefono, String ocupacion, String direccion){
        //Verifica si el doc del cliente a crear no coincide con el doc de algún otro cliente ya creado en el json correspondiente al tipo de cliente. Si esto se cumple:

        ClientePersona clienteNuevo = new ClientePersona(doc, nombre, telefono, ocupacion, direccion);
        Serializador.anadirJson(clienteNuevo, "registro_clientes_persona.json");
    }

    public static void crearCuenta(String idClienteTitular, String idCuenta, String tipoCuenta){
        Cliente clienteTitular = Buscador.buscaCliente(idClienteTitular);
        if(tipoCuenta.equals("Corriente")){
            CuentaCorriente cuentaNueva = new CuentaCorriente(idCuenta, clienteTitular, sucursalOrigen);
            Serializador.anadirJson(cuentaNueva, "registro_cuentas_corriente.json");
            if(!clienteTitular.isEstaSuscrito()){clienteTitular.setEstaSuscrito(true);}
        }
        else{
            CuentaAhorros cuentaNueva = new CuentaAhorros(idCuenta, clienteTitular, sucursalOrigen);
            Serializador.anadirJson(cuentaNueva, "registro_cuentas_ahorros.json");
        }
    } // suscribir cliente si no tenía cuentas activas y ahora sí

    public Sucursal getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(Sucursal sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public Cajero(Sucursal sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public Cajero() {
    }
}
