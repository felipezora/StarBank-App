package model.account;

import model.client.Cliente;
import model.management.Sucursal;

public class CuentaAhorros extends Cuenta {
    float interesMensual;

    public CuentaAhorros(String idCuenta, Cliente clienteTitular, Sucursal lugarApertura) {
        super(idCuenta, clienteTitular, lugarApertura);
    }
}
