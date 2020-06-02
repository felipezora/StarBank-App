package sample;

import java.time.LocalDateTime;

public class OperacionConSaldo extends Operacion {

    protected float saldo;

    public OperacionConSaldo(String nombreOperacion, LocalDateTime tiempo, Sucursal surcursalOrigen, String idCuentaObjetivo, float saldo) {
        super(nombreOperacion, tiempo, surcursalOrigen, idCuentaObjetivo);
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
