package controller.creation;

import controller.Formulario;
import datamanagement.Mediador;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.management.Cajero;

public class ControladorCrearCliente implements Formulario {

    // Elementos del cliente Empresa

    @FXML
    private TextField txtDocuREmpresa;
    @FXML
    private TextField txtTelREmpresa;
    @FXML
    private TextField txtNomREmpresa;
    @FXML
    private TextField txtOcuREmpresa;
    @FXML
    private TextField txtNitEmpresa;
    @FXML
    private TextField txtNomEmpresa;
    @FXML
    private TextField txtSecEmpresa;
    @FXML
    private TextField txtDirEmpresa;
    @FXML

    //Elementos del cliente Persona Natural

    private TextField txtDocuPer;
    @FXML
    private TextField txtTelPer;
    @FXML
    private TextField txtNomPer;
    @FXML
    private TextField txtOcuPer;
    @FXML
    private TextField txtDirPer;

    public void guardarRegistroEmpresa_action(){
        String doc;
        String nombre;
        String telefono;
        String ocupacion;
        String direccion;
        String nit;
        String nombreEmpresa;
        String sectorComercial;

        if(txtDocuREmpresa.getText().trim().isEmpty() || txtTelREmpresa.getText().trim().isEmpty() || txtNomREmpresa.getText().trim().isEmpty()
                || txtOcuREmpresa.getText().trim().isEmpty() || txtNitEmpresa.getText().trim().isEmpty() || txtNitEmpresa.getText().trim().isEmpty()
                || txtNomEmpresa.getText().trim().isEmpty() || txtSecEmpresa.getText().trim().isEmpty() || txtDirEmpresa.getText().trim().isEmpty()){
            desplegarVentanaAlerta("Por favor llene todos los campos");
            return;
        }

        doc = txtDocuREmpresa.getText();
        nombre = txtNomREmpresa.getText();
        telefono = txtTelREmpresa.getText();
        ocupacion = txtOcuREmpresa.getText();
        direccion = txtDirEmpresa.getText();
        nit = txtNitEmpresa.getText();
        nombreEmpresa = txtNomEmpresa.getText();
        sectorComercial = txtSecEmpresa.getText();
        if(Mediador.buscaCliente(doc)!=null){
            desplegarVentanaAlerta("Ya existe un cliente registrado con este documento");
            return;
        }
        Cajero.crearClienteEmpresa(doc, nombre, telefono, ocupacion, direccion, nit, nombreEmpresa, sectorComercial);
        limpiarFormulario();
        desplegarVentanaInformacion("Cliente registrado satisfactoriamente");
    }

    public void guardarRegistroPersona_action(){
        String doc;
        String nombre;
        String telefono;
        String ocupacion;
        String direccion;

        if(txtDocuPer.getText().trim().isEmpty() || txtNomPer.getText().trim().isEmpty() || txtTelPer.getText().trim().isEmpty()
                || txtOcuPer.getText().trim().isEmpty() || txtDirPer.getText().trim().isEmpty()){
            desplegarVentanaAlerta("Por favor llene todos los campos");
            return;
        }

        doc = txtDocuPer.getText();
        nombre = txtNomPer.getText();
        telefono = txtTelPer.getText();
        ocupacion = txtOcuPer.getText();
        direccion = txtDirPer.getText();
        if(Mediador.buscaCliente(doc)!=null){
            desplegarVentanaAlerta("Ya existe una cliente registrado con este documento");
            return;
        }
        Cajero.crearClientePersona(doc, nombre, telefono, ocupacion, direccion);
        limpiarFormulario();
        desplegarVentanaInformacion("Cliente registrado satisfactoriamente");
    }

    @Override
    public void limpiarFormulario() {
        txtDocuREmpresa.setText(null);
        txtTelREmpresa.setText(null);
        txtNomREmpresa.setText(null);
        txtOcuREmpresa.setText(null);
        txtNitEmpresa.setText(null);
        txtNomEmpresa.setText(null);
        txtSecEmpresa.setText(null);
        txtDirEmpresa.setText(null);
        txtDocuPer.setText(null);
        txtTelPer.setText(null);
        txtNomPer.setText(null);
        txtOcuPer.setText(null);
        txtDirPer.setText(null);
    }

    @Override
    public void desplegarVentanaInformacion(String texto) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("¡ATENCION!");
        a.setContentText(texto);
        a.setHeaderText(null);
        a.showAndWait();
    }

    @Override
    public void desplegarVentanaAlerta(String texto) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("¡ATENCION!");
        a.setContentText(texto);
        a.setHeaderText(null);
        a.showAndWait();
    }
}
