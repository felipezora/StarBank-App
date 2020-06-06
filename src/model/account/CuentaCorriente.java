package model.account;

import model.client.Cliente;
import model.management.Sucursal;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(String idCuenta, Cliente clienteTitular, Sucursal lugarApertura) {
        super(idCuenta, clienteTitular, lugarApertura);
    }
}