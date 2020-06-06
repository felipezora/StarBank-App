package datamanagement;

import model.account.Cuenta;
import model.account.CuentaCorriente;
import model.client.Cliente;
import model.management.Sucursal;

public class Mediador {
    public static Cliente buscaCliente(String id){
        Cliente[] clientes = Serializador.deserializarCliente("registro_clientes.json");
        if(clientes!=null){
            for(Cliente clienteIndice: clientes){
                if(clienteIndice.getDoc().equals(id)){
                    return clienteIndice;
                }
            }
        }
        return null;
    }

    public static Cuenta buscaCuenta(String id){
        Cuenta[] cuentas = Serializador.deserializarCuenta("registro_cuentas.json");
        if(cuentas!=null){
            for(Cuenta cuentaIndice: cuentas){
                if(cuentaIndice.getIdCuenta().equalsIgnoreCase(id)){
                    return cuentaIndice;
                }
            }
        }
        return null;
    }

    public static void consignaStarBank(double cantidad, double interes){
        CuentaCorriente starBank;
        Cuenta[] cuentas = Serializador.deserializarCuenta("registro_cuentas.json");
        String idStarbank = "starbank";
        idStarbank += Sucursal.getInstance().getIdSucursal();
        for(Cuenta cuentaIndice: cuentas){
            if(cuentaIndice.getIdCuenta().equalsIgnoreCase(idStarbank) ){
                cuentaIndice.consignar(cantidad*interes);
            }
        }
    }

    public static void editaSaldoCuentaJson(Cuenta cuentaEditada){
        Cuenta[] cuentas = Serializador.deserializarCuenta("registro_cuentas.json");
        for(Cuenta cuentaIndice: cuentas){
            if (cuentaIndice.getIdCuenta().equalsIgnoreCase(cuentaEditada.getIdCuenta())){
                cuentaIndice.setSaldoCuenta(cuentaEditada.getSaldoCuenta());
            }
        }
        Serializador.serializar(cuentas,"registro_cuentas.json");
    }

    public static void editaEstadoCuentaJson(Cuenta cuentaEditada){
        Cuenta[] cuentas = Serializador.deserializarCuenta("registro_cuentas.json");
        for(Cuenta cuentaIndice: cuentas){
            if (cuentaIndice.getIdCuenta().equalsIgnoreCase(cuentaEditada.getIdCuenta())){
                cuentaIndice.setEstaActiva(cuentaEditada.isEstaActiva());
            }
        }
        Serializador.serializar(cuentas,"registro_cuentas.json");
    }

    public static void editaSuscripcionClienteJson(Cliente clienteEditado){
        Cliente[] clientes = Serializador.deserializarCliente("registro_clientes.json");
        for(Cliente clienteIndice: clientes){
            if (clienteIndice.getDoc().equalsIgnoreCase(clienteEditado.getDoc())){
                clienteIndice.setEstaSuscrito(clienteEditado.isEstaSuscrito());
            }
        }
        Serializador.serializar(clientes,"registro_clientes.json");
    }
}
