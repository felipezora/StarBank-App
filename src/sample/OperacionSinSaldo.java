package sample;

import java.time.LocalDateTime;

public class OperacionSinSaldo extends Operacion {
    public OperacionSinSaldo(String nombreOperacion, LocalDateTime tiempo, Sucursal sucursalOrigen, String idObjetivo) {
        super(nombreOperacion, tiempo, sucursalOrigen, idObjetivo);
    }
}
