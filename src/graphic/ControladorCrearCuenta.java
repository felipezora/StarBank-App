package graphic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import json.Buscador;
import sample.Cajero;
import sample.RandomGenerator;

public class ControladorCrearCuenta {

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
        // comprobar que el id ingresado en cliente titular sí corresponda a un cliente real
        // suscribir al cliente si es su primera cuenta
        String idClienteTitular = txtClienteTitular.getText();
        String idCuenta = lbIdCuenta.getText();
        String tipoCuenta = (String) cuentaBox.getValue();
        if(Buscador.buscaCliente(idClienteTitular) != null){
            Cajero.crearCuenta(idClienteTitular,idCuenta,tipoCuenta);
            desplegarVentanaConfirmacion();
        }
        else {
            desplegarVentanaAlerta();
        }
    }

    public void desplegarVentanaAlerta(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("¡ATENCION!");
        a.setContentText("Por favor ingrese un id válido para el titular de la cuenta");
        a.setHeaderText(null);
        a.showAndWait();
    }

    public void desplegarVentanaConfirmacion(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("¡ATENCION!");
        a.setContentText("Cuenta creada con éxito");
        a.setHeaderText(null);
        a.showAndWait();
    }
}
