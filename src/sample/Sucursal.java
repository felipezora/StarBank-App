package sample;

public class Sucursal {
    private String idSucursal;
    private String direccionSucursal;
    private String ciudadSucursal;
    private String nombreSucursal;

    public Sucursal(String idSucursal, String direccionSucursal, String ciudadSucursal, String nombreSucursal) {
        this.idSucursal = idSucursal;
        this.direccionSucursal = direccionSucursal;
        this.ciudadSucursal = ciudadSucursal;
        this.nombreSucursal = nombreSucursal;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getCiudadSucursal() {
        return ciudadSucursal;
    }

    public void setCiudadSucursal(String ciudadSucursal) {
        this.ciudadSucursal = ciudadSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
}
