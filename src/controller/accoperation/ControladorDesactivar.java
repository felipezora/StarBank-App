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

public class ControladorDesactivar implements Formulario {
    ObservableList<String> tipoCuentaList = FXCollections.observableArrayList("Corriente", "Ahorros");
    @FXML
    private ChoiceBox tipoCuentaBox;
    @FXML
    private TextField txtId;

    @FXML
    private void initialize(){ // método para poder desplegar la comboBox (la etiqueta @FXML obliga a que se ejecute)
        tipoCuentaBox.setValue("Corriente");
        tipoCuentaBox.setItems(tipoCuentaList);
    }

    public void clickDesactivar_action(){
        String idCuentaObjetivo = txtId.getText();
        String tipoCuenta = (String) tipoCuentaBox.getValue();
        Cuenta cuentaObjetivo = Mediador.buscaCuenta(idCuentaObjetivo);
        if(tipoCuenta.equalsIgnoreCase("Corriente")){
            if(cuentaObjetivo!=null){
                double cantidadRetirada = cuentaObjetivo.desactivar(0.017);
                Mediador.consignaStarBank(cantidadRetirada, 0.017);
                cuentaObjetivo.getClienteTitular().verificarSuscripcion();
                limpiarFormulario();
                double cantidadRetiradaNeta = cantidadRetirada - (cantidadRetirada*0.017);
                desplegarVentanaInformacion("Desactivación realizada con éxito. Se han retirado de su cuenta $"+cantidadRetiradaNeta+" pesos");
                }
            else{desplegarVentanaAlerta("Por favor ingrese un id válido la cuenta a desactivar");}
            }
        else{
            if(cuentaObjetivo!=null){
                double cantidadRetirada = cuentaObjetivo.desactivar(0.02);
                Mediador.consignaStarBank(cantidadRetirada, 0.02);
                cuentaObjetivo.getClienteTitular().verificarSuscripcion();
                limpiarFormulario();
                double cantidadRetiradaNeta = cantidadRetirada - (cantidadRetirada*0.02);
                desplegarVentanaInformacion("Desactivación realizada con éxito. Se han retirado de su cuenta $"+cantidadRetiradaNeta+" pesos");
            }
            else{desplegarVentanaAlerta("Por favor ingrese un id válido la cuenta a desactivar");}
        }
    }

    @Override
    public void limpiarFormulario() {
        txtId.setText(null);
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
