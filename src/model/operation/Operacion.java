package model.operation;

import model.management.Sucursal;
import model.account.Cuenta;

import java.util.Date;

public abstract class Operacion {

    protected String nombreOperacion;
    protected Cuenta cuentaObjetivo;
    protected Date tiempo;
    protected Sucursal sucursalOrigen;

    public Operacion(String nombreOperacion, Cuenta cuentaObjetivo, Date tiempo, Sucursal sucursalOrigen) {
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

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public Sucursal getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(Sucursal sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }
}
