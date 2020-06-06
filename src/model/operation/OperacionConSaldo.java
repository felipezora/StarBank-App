package model.operation;

import model.management.Sucursal;
import model.account.Cuenta;

import java.util.Date;

public class OperacionConSaldo extends Operacion {

    protected double valorOperacion;

    public OperacionConSaldo(String nombreOperacion, Cuenta cuentaObjetivo, Date tiempo, Sucursal sucursalOrigen, double valorOperacion) {
        super(nombreOperacion, cuentaObjetivo, tiempo, sucursalOrigen);
        this.valorOperacion = valorOperacion;
    }
}
