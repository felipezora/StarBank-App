package controller.accoperation;

import controller.Formulario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import datamanagement.Mediador;
import model.account.Cuenta;


public class ControladorConsignar implements Formulario {

    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtIdCuenta;

    public void guardarConsignacion_action(){
        if(txtCantidad.getText().trim().isEmpty()){
            desplegarVentanaAlerta("Por favor ingrese una cantidad válida a consignar");
            return;
        }
        double cantidad;
        try{
            cantidad = Double.parseDouble(txtCantidad.getText());
        } catch (NumberFormatException e){
            desplegarVentanaAlerta("Por favor ingrese una cantidad válida a consignar");
            return;
        }
        if(cantidad <=0 || cantidad > 1000000000){
            desplegarVentanaAlerta("Por favor ingrese una cantidad válida a consignar");
            return;
        }
        String idCuentaObjetivo = txtIdCuenta.getText();
        boolean activarCuenta;
        Cuenta cuentaObjetivo;
        cuentaObjetivo = Mediador.buscaCuenta(idCuentaObjetivo);
        if(cuentaObjetivo!=null){
            cuentaObjetivo.consignar(cantidad);
            activarCuenta = cuentaObjetivo.verificarActivacion();
            limpiarFormulario();
            desplegarVentanaInformacion("Consignación realizada con éxito");
            if(activarCuenta){
                desplegarVentanaInformacion("Su cuenta estaba desactivada y ahora se ha activado");
                cuentaObjetivo.getClienteTitular().cambiarSuscripcion();
            }
        }
        else {desplegarVentanaAlerta("Por favor ingrese un id válido para la cuenta a consignar");}
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
