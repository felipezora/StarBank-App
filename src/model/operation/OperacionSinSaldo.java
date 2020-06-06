package model.operation;

import model.management.Sucursal;
import model.account.Cuenta;

import java.util.Date;

public class OperacionSinSaldo extends Operacion {
    public OperacionSinSaldo(String nombreOperacion, Cuenta cuentaObjetivo, Date tiempo, Sucursal sucursalOrigen) {
        super(nombreOperacion, cuentaObjetivo, tiempo, sucursalOrigen);
    }
}
