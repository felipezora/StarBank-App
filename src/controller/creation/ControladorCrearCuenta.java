package controller.creation;

import controller.Formulario;
import extra.RandomGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import datamanagement.Mediador;
import model.management.Cajero;

public class ControladorCrearCuenta implements Formulario {

    ObservableList<String> cuentaList = FXCollections.observableArrayList("Corriente", "Ahorros");
    @FXML
    private ChoiceBox cuentaBox;
    @FXML
    private Label lbIdCuenta;
    @FXML
    private TextField txtClienteTitular;

    @FXML
    private void initialize(){ // método para poder desplegar la comboBox (la etiqueta @FXML obliga a que se ejecute)
        cuentaBox.setValue("Corriente");
        cuentaBox.setItems(cuentaList);
    }

    public void generarIdCuenta_action(){
        String id = RandomGenerator.generateTypeOne();
        lbIdCuenta.setText(id);
    }

    public void clickGuardar_action(){
        String idClienteTitular = txtClienteTitular.getText();
        String idCuenta = lbIdCuenta.getText();
        String tipoCuenta = (String) cuentaBox.getValue();
        if(Mediador.buscaCliente(idClienteTitular)==null){
            desplegarVentanaAlerta("Por favor ingrese un id válido para el titular de la cuenta");
            return;
        }
        if(lbIdCuenta.getText().trim().isEmpty()){
            desplegarVentanaAlerta("Primero necesita obtener un id presionando el botón 'Generar Id'");
            return;
        }
        limpiarFormulario();
        Cajero.crearCuenta(idClienteTitular,idCuenta,tipoCuenta);
        desplegarVentanaInformacion("Cuenta creada con éxito");
    }

    @Override
    public void limpiarFormulario() {
        lbIdCuenta.setText(null);
        txtClienteTitular.setText(null);
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
