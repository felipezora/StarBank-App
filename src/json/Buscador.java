package json;

import sample.Cliente;
import sample.ClienteEmpresa;
import sample.ClientePersona;

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
}
