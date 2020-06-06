package controller.accoperation;

import controller.Formulario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import datamanagement.Mediador;
import model.account.Cuenta;

public class ControladorRetirar implements Formulario{
    ObservableList<String> tipoCuentaList = FXCollections.observableArrayList("Corriente", "Ahorros");
    @FXML
    private ChoiceBox tipoCuentaBox;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtIdCuenta;

    @FXML
    private void initialize(){ // método para poder desplegar la comboBox (la etiqueta @FXML obliga a que se ejecute)
        tipoCuentaBox.setValue("Corriente");
        tipoCuentaBox.setItems(tipoCuentaList);
    }

    public void guardarRetiro_action(){
        if(txtCantidad.getText().trim().isEmpty()){
            desplegarVentanaAlerta("Por favor ingrese una cantidad válida a retirar");
            return;
        }
        double cantidad;
        try{
            cantidad = Double.parseDouble(txtCantidad.getText());
        } catch (NumberFormatException e){
            desplegarVentanaAlerta("Por favor ingrese una cantidad válida a retirar");
            return;
        }
        if(cantidad <=0 || cantidad > 1000000000){
            desplegarVentanaAlerta("Por favor ingrese una cantidad válida a retirar");
            return;
        }
        String idCuentaObjetivo = txtIdCuenta.getText();
        String tipoCuenta = (String) tipoCuentaBox.getValue();
        Cuenta cuentaObjetivo = Mediador.buscaCuenta(idCuentaObjetivo);
        if(tipoCuenta.equalsIgnoreCase("Corriente")){
            if(cuentaObjetivo!=null){
                if(cuentaObjetivo.retirar(cantidad, 0.017)){
                    Mediador.consignaStarBank(cantidad, 0.017);
                    limpiarFormulario();
                    desplegarVentanaInformacion("Retiro realizado con éxito");
                }
                else{desplegarVentanaAlerta("Saldo insuficiente o cantidad a retirar inválida");}
            }
            else{desplegarVentanaAlerta("Por favor ingrese un id válido para la cuenta a retirar");}
        }
        else{
            if(cuentaObjetivo!=null){
                if(cuentaObjetivo.retirar(cantidad, 0.02)){
                    Mediador.consignaStarBank(cantidad, 0.02);
                    limpiarFormulario();
                    desplegarVentanaInformacion("Retiro realizado con éxito");
                }
                else{desplegarVentanaAlerta("Saldo insuficiente o cantidad a retirar inválida");}
            }
            else{desplegarVentanaAlerta("Por favor ingrese un id válido para la cuenta a retirar");}
        }
    }

    @Override
    public void limpiarFormulario() {
        txtCantidad.setText(null);
        txtIdCuenta.setText(null);
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

