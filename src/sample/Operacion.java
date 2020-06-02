package sample;

import java.time.LocalDateTime;

public abstract class Operacion {

    protected String nombreOperacion;
    protected LocalDateTime tiempo;
    protected Sucursal sucursalOrigen;
    protected String idCuentaObjetivo;

    public Operacion(String nombreOperacion, LocalDateTime tiempo, Sucursal sucursalOrigen, String idCuentaObjetivo) {
        this.nombreOperacion = nombreOperacion;
        this.tiempo = tiempo;
        this.sucursalOrigen = sucursalOrigen;
        this.idCuentaObjetivo = idCuentaObjetivo;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }

    public Sucursal getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(Sucursal sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public String getIdCuentaObjetivo() {
        return idCuentaObjetivo;
    }

    public void setIdCuentaObjetivo(String idCuentaObjetivo) {
        this.idCuentaObjetivo = idCuentaObjetivo;
    }
}
