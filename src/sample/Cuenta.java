package sample;

public class Cuenta {

    protected String idCuenta;
    protected Cliente clienteTitular;
    protected double saldoCuenta = 0;
    protected boolean estaActiva = false; // cuando se haga la consignación inicial de $20000, la cuenta pasará a estar activa
    protected Sucursal lugarApertura;
    protected Operacion[] operaciones;

    public void consignar(double cantidadConsignada){
        saldoCuenta = saldoCuenta + cantidadConsignada;
        Cuenta[] cuentas;
        //OperacionConSaldo nuevaConsignacion = new OperacionConSaldo("Consignación",)
    }

    public boolean verificarActivacion(){
        if(saldoCuenta >= 20000 && !estaActiva){
            estaActiva = true;

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

    public Operacion[] getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(Operacion[] operaciones) {
        this.operaciones = operaciones;
    }
}
