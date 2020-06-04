package sample;

import java.time.LocalDateTime;

public abstract class Operacion {

    protected String nombreOperacion;
    protected Cuenta cuentaObjetivo;
    protected LocalDateTime tiempo;
    protected Sucursal sucursalOrigen;

    public Operacion(String nombreOperacion, Cuenta cuentaObjetivo, LocalDateTime tiempo, Sucursal sucursalOrigen) {
        this.nombreOperacion = nombreOperacion;
        this.cuentaObjetivo = cuentaObjetivo;
        this.tiempo = tiempo;
        this.sucursalOrigen = sucursalOrigen;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public Cuenta getCuentaObjetivo() {
        return cuentaObjetivo;
    }

    public void setCuentaObjetivo(Cuenta cuentaObjetivo) {
        this.cuentaObjetivo = cuentaObjetivo;
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
}
