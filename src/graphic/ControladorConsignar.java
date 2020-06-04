package graphic;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import json.Buscador;
import sample.Cuenta;
import sample.RandomGenerator;


public class ControladorConsignar {

    @FXML
    private Label lbIdOperacion;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtIdCuenta;

    public void generarIdOperacion_action(){
        String id = RandomGenerator.generateTypeTwo();
        lbIdOperacion.setText(id);
    }

    public void guardarConsignacion_action(){
        double cantidad = Double.parseDouble(txtCantidad.getText());
        String idCuentaObjetivo = txtIdCuenta.getText();
        String idOperacion = lbIdOperacion.getText();
        boolean activarCuenta = false;
        Cuenta cuentaObjetivo;
        cuentaObjetivo = Buscador.buscaCuenta(idCuentaObjetivo);
        if(cuentaObjetivo==null){desplegarVentanaAlerta();}
        else{
            cuentaObjetivo.consignar(cantidad);
            activarCuenta = cuentaObjetivo.verificarActivacion();
            desplegarVentanaConfirmacion();
        }
        if(activarCuenta){desplegarVentanaActivacion();}

    }

    public void desplegarVentanaConfirmacion(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("¡ATENCION!");
        a.setContentText("Consignación realizada con éxito");
        a.setHeaderText(null);
        a.showAndWait();
    }

    public void desplegarVentanaActivacion(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("¡ATENCION!");
        a.setContentText("Su cuenta estaba desactivada y ahora se ha activado");
        a.setHeaderText(null);
        a.showAndWait();
    }

    public void desplegarVentanaAlerta(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("¡ATENCION!");
        a.setContentText("Por favor ingrese un id válido la cuenta consignada");
        a.setHeaderText(null);
        a.showAndWait();
    }
}
