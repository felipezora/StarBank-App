package model.client;

public class ClienteEmpresa extends Cliente {

    protected String nit;
    protected String nombreEmpresa;
    protected String sectorComercial;

    public ClienteEmpresa(String doc, String nombre, String telefono, String ocupacion, String direccion, String nit, String nombreEmpresa, String sectorComercial) {
        super(doc, nombre, telefono, ocupacion, direccion);
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.sectorComercial = sectorComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSectorComercial() {
        return sectorComercial;
    }

    public void setSectorComercial(String sectorComercial) {
        this.sectorComercial = sectorComercial;
    }
}
