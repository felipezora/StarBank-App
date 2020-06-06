package controller.transition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import datamanagement.Serializador;
import model.management.Sucursal;

import java.io.IOException;

public class ControladorInicio {

    ObservableList<String> sucursalList = FXCollections.observableArrayList("Centro", "Parque Bolivar", "Santo Domingo");
    @FXML
    private ChoiceBox sucursalBox;

    @FXML
    private void initialize(){ // método para poder desplegar la comboBox (la etiqueta @FXML obliga a que se ejecute)
        sucursalBox.setValue("Centro");
        sucursalBox.setItems(sucursalList);
    }

    public void clickContinuar_action(ActionEvent event) throws IOException {
        Sucursal[] sucursales = Serializador.deserializarSucursales("registro_sucursales.json");
        String nombreSucursalEscogida = (String) sucursalBox.getValue();
        // Una vez sabemos desde qué sucursal trabajaremos, asignamos los atributos de esta al singleton
        for(Sucursal sucursalIndice: sucursales){
            if(sucursalIndice.getNombreSucursal().equalsIgnoreCase(nombreSucursalEscogida)){
                Sucursal.getInstance().setCiudadSucursal(sucursalIndice.getCiudadSucursal());
                Sucursal.getInstance().setDireccionSucursal(sucursalIndice.getDireccionSucursal());
                Sucursal.getInstance().setIdSucursal(sucursalIndice.getIdSucursal());
                Sucursal.getInstance().setNombreSucursal(sucursalIndice.getNombreSucursal());
            }
        }
        Parent root = FXMLLoader.load(getClass().getResource("/view/accesing/cajero.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
