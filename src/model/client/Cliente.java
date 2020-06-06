package model.client;

import datamanagement.Mediador;
import datamanagement.Serializador;
import model.account.Cuenta;

public class Cliente {
    protected String doc;
    protected String nombre;
    protected String telefono;
    protected String ocupacion;
    protected String direccion;
    protected boolean estaSuscrito = false; // cuando se añada la primera cuenta al cliente, pasará a estar suscrito

    public void cambiarSuscripcion(){
        if(!estaSuscrito){
            estaSuscrito = true;
            Mediador.editaSuscripcionClienteJson(this);
        }
    }

    public void verificarSuscripcion(){
        Cuenta[] cuentas = Serializador.deserializarCuenta("registro_cuentas.json");
        int cuentasActivas = 0;
        for(Cuenta cuentaIndice: cuentas){
            if(cuentaIndice.getClienteTitular().getDoc().equalsIgnoreCase(this.getDoc()) && cuentaIndice.isEstaActiva()){
                cuentasActivas = cuentasActivas + 1;
            }
        }
        if(cuentasActivas==0){
            estaSuscrito=false;
            Mediador.editaSuscripcionClienteJson(this);
        }
    }

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