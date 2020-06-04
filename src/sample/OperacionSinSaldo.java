package sample;

import java.time.LocalDateTime;

public class OperacionSinSaldo extends Operacion {
    public OperacionSinSaldo(String nombreOperacion, Cuenta cuentaObjetivo, LocalDateTime tiempo, Sucursal sucursalOrigen) {
        super(nombreOperacion, cuentaObjetivo, tiempo, sucursalOrigen);
    }
}
