package sample;

public class CuentaAhorros extends Cuenta {
    float interesMensual;

    public CuentaAhorros(String idCuenta, Cliente clienteTitular, Sucursal lugarApertura, float interesMensual) {
        super(idCuenta, clienteTitular, lugarApertura);
        this.interesMensual = interesMensual;
    }

    public float getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(float interesMensual) {
        this.interesMensual = interesMensual;
    }
}
