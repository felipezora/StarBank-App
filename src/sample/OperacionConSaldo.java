package sample;

import java.time.LocalDateTime;

public class OperacionConSaldo extends Operacion {

    protected double saldo;

    public OperacionConSaldo(String nombreOperacion, Cuenta cuentaObjetivo, LocalDateTime tiempo, Sucursal sucursalOrigen, double saldo) {
        super(nombreOperacion, cuentaObjetivo, tiempo, sucursalOrigen);
        this.saldo = saldo;
    }
}
