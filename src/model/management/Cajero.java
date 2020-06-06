package model.management;

import datamanagement.Mediador;
import datamanagement.Serializador;
import model.account.CuentaAhorros;
import model.account.CuentaCorriente;
import model.client.Cliente;
import model.client.ClienteEmpresa;
import model.client.ClientePersona;

public class Cajero {

    public static void crearClienteEmpresa (String doc, String nombre, String telefono, String ocupacion, String direccion, String nit, String nombreEmpresa, String sectorComercial){
        //Verifica si el doc del cliente a crear no coincide con el doc de algún otro cliente ya creado en el json correspondiente al tipo de cliente. Si esto se cumple:

        ClienteEmpresa clienteNuevo = new ClienteEmpresa(doc, nombre, telefono, ocupacion, direccion, nit, nombreEmpresa, sectorComercial);
        Serializador.anadirJson(clienteNuevo, "registro_clientes.json");
    }

    public static void crearClientePersona (String doc, String nombre, String telefono, String ocupacion, String direccion){
        //Verifica si el doc del cliente a crear no coincide con el doc de algún otro cliente ya creado en el json correspondiente al tipo de cliente. Si esto se cumple:

        ClientePersona clienteNuevo = new ClientePersona(doc, nombre, telefono, ocupacion, direccion);
        Serializador.anadirJson(clienteNuevo, "registro_clientes.json");
    }

    public static void crearCuenta(String idClienteTitular, String idCuenta, String tipoCuenta){
        Cliente clienteTitular = Mediador.buscaCliente(idClienteTitular);
        if(tipoCuenta.equalsIgnoreCase("Corriente")){
            CuentaCorriente cuentaNueva = new CuentaCorriente(idCuenta, clienteTitular, Sucursal.getInstance());
            Serializador.anadirJson(cuentaNueva, "registro_cuentas.json");
        }else {
            CuentaAhorros cuentaNueva = new CuentaAhorros(idCuenta, clienteTitular, Sucursal.getInstance());
            Serializador.anadirJson(cuentaNueva, "registro_cuentas.json");
        }
    }
}
