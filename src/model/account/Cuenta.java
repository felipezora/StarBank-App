package model.account;

import datamanagement.Mediador;
import datamanagement.Serializador;
import model.client.Cliente;
import model.operation.OperacionConSaldo;
import model.operation.OperacionSinSaldo;
import model.management.Sucursal;

import java.util.Date;

public class Cuenta {

    protected String idCuenta;
    protected Cliente clienteTitular;
    protected double saldoCuenta = 0;
    protected boolean estaActiva = false; // cuando se haga la consignación inicial de $20000, la cuenta pasará a estar activa
    protected Sucursal lugarApertura;

    public void consignar(double cantidadConsignada){
        Date tiempo = new Date();
        saldoCuenta = saldoCuenta + cantidadConsignada;
        Mediador.editaSaldoCuentaJson(this);
        OperacionConSaldo nuevaConsignacion = new OperacionConSaldo("Consignación", this, tiempo, Sucursal.getInstance(), cantidadConsignada);
        Serializador.anadirJson(nuevaConsignacion, "registro_operaciones.json");
    }

    public double desactivar(double interes){
        Date tiempo = new Date();
        double cantidadRetirada = saldoCuenta;
        saldoCuenta = 0;
        estaActiva = false;
        Mediador.editaSaldoCuentaJson(this);
        Mediador.editaEstadoCuentaJson(this);
        OperacionConSaldo nuevaDesactivacion = new OperacionConSaldo("Desactivación de cuenta", this, tiempo, Sucursal.getInstance(), cantidadRetirada - cantidadRetirada*interes);
        Serializador.anadirJson(nuevaDesactivacion, "registro_operaciones.json");
        return cantidadRetirada;
    }

    public boolean retirar(double cantidadRetirada, double interes){
        Date tiempo = new Date();
        if(cantidadRetirada >= 20000 && cantidadRetirada%10000==0){
            if(saldoCuenta >= 10000+cantidadRetirada+(cantidadRetirada*interes)){
                saldoCuenta = saldoCuenta - (cantidadRetirada+(cantidadRetirada*interes));
                Mediador.editaSaldoCuentaJson(this);
                OperacionConSaldo nuevoRetiro = new OperacionConSaldo("Retiro", this, tiempo, Sucursal.getInstance(), cantidadRetirada - cantidadRetirada*interes);
                Serializador.anadirJson(nuevoRetiro, "registro_operaciones.json");
                return true;
            }
        }
        return false;
    }

    public boolean verificarActivacion(){
        Date tiempo = new Date();
        if(saldoCuenta >= 20000 && !estaActiva){
            estaActiva = true;
            Mediador.editaEstadoCuentaJson(this);
            OperacionSinSaldo nuevaActivacion = new OperacionSinSaldo("Activación de cuenta", this, tiempo, Sucursal.getInstance());
            Serializador.anadirJson(nuevaActivacion, "registro_operaciones.json");
            return true;
        }
        return false;
    }

    public Cuenta(String idCuenta, Cliente clienteTitular, Sucursal lugarApertura) {
        this.idCuenta = idCuenta;
        this.clienteTitular = clienteTitular;
        this.lugarApertura = lugarApertura;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cliente getClienteTitular() {
        return clienteTitular;
    }

    public void setClienteTitular(Cliente clienteTitular) {
        this.clienteTitular = clienteTitular;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public Sucursal getLugarApertura() {
        return lugarApertura;
    }

    public void setLugarApertura(Sucursal lugarApertura) {
        this.lugarApertura = lugarApertura;
    }
}
