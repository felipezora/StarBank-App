package sample;

import json.Serializador;

public class Cajero {

    static Sucursal sucursalOrigen;

    public static void crearClienteEmpresa (String doc, String nombre, String telefono, String ocupacion, String direccion, String nit, String nombreEmpresa, String sectorComercial){
        //Verifica si el doc del cliente a crear no coincide con el doc de algún otro cliente ya creado en el json correspondiente al tipo de cliente. Si esto se cumple:

        ClienteEmpresa clienteNuevo = new ClienteEmpresa(doc, nombre, telefono, ocupacion, direccion, nit, nombreEmpresa, sectorComercial);
        Serializador.serializar(clienteNuevo, "registro_clientes_empresa.json");
    }

    public static void crearClientePersona (String doc, String nombre, String telefono, String ocupacion, String direccion){
        //Verifica si el doc del cliente a crear no coincide con el doc de algún otro cliente ya creado en el json correspondiente al tipo de cliente. Si esto se cumple:

        ClientePersona clienteNuevo = new ClientePersona(doc, nombre, telefono, ocupacion, direccion);
        Serializador.serializar(clienteNuevo, "registro_clientes_empresa.json");
    }

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
