package json;

import sample.*;

public class Buscador {
    public static Cliente buscaCliente(String id){
        boolean encontroCliente = false;
        ClientePersona[] clientesP = Serializador.deserializarClientePersona("registro_clientes_persona.json");
        if(clientesP!=null){
            for(ClientePersona clienteIndice: clientesP){
                if(clienteIndice.getDoc().equals(id)){
                    encontroCliente = true;
                    return clienteIndice;
                }
            }
        }
        if (!encontroCliente){ // si no encontró al cliente en el archivo de clientes persona
            ClienteEmpresa[] clientesE = Serializador.deserializarClienteEmpresa("registro_clientes_empresa.json");
            if(clientesE!=null){
                for(ClienteEmpresa clienteIndice: clientesE){
                    if(clienteIndice.getDoc().equals(id)){
                        return clienteIndice;
                    }
                }
            }
        }
        return null;
    }

    public static Cuenta buscaCuenta(String id){
        boolean encontroCuenta = false;
        CuentaCorriente[] cuentasC = Serializador.deserializarCuentaCorriente("registro_cuentas_corriente.json");
        if(cuentasC!=null){
            for(CuentaCorriente cuentaIndice: cuentasC){
                if(cuentaIndice.getIdCuenta().equalsIgnoreCase(id)){
                    encontroCuenta = true;
                    return cuentaIndice;
                }
            }
        }
        if (!encontroCuenta){ // si no encontró a la cuenta en el archivo de cuentas corriente
            CuentaAhorros[] cuentasA = Serializador.deserializarCuentaAhorros("registro_cuentas_ahorros.json");
            if(cuentasA!=null){
                for(CuentaAhorros cuentaIndice: cuentasA){
                    if(cuentaIndice.getIdCuenta().equalsIgnoreCase(id)){
                        return cuentaIndice;
                    }
                }
            }
        }
        return null;
    }
}
