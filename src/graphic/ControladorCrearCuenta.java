package graphic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Label lbAlerta;

    @FXML
    private void initialize(){ // método para poder desplegar la comboBox (la etiqueta @FXML obliga a que se ejecute)
        cuentaBox.setValue("Corriente");
        cuentaBox.setItems(cuentaList);
    }

    public void generarIdCuenta_action(){
        String id = RandomGenerator.randomGeneration();
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
            lbAlerta.setText("Titular de la cuenta encontrado");
        }
        else {
            lbAlerta.setText("Alerta: Ingrese un id válido para el titular de la cuenta");
        }
    }
}
