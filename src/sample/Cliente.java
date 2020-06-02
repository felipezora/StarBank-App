package sample;

public class Cliente {
    protected String doc;
    protected String nombre;
    protected String telefono;
    protected String ocupacion;
    protected String direccion;
    protected boolean estaSuscrito = false; // cuando se añada la primera cuenta al cliente, pasará a estar suscrito

    public Cliente(String doc, String nombre, String telefono, String ocupacion, String direccion) {
        this.doc = doc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstaSuscrito() {
        return estaSuscrito;
    }

    public void setEstaSuscrito(boolean estaSuscrito) {
        this.estaSuscrito = estaSuscrito;
    }
}