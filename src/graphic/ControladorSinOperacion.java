package graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import json.Serializador;
import sample.Cajero;

import java.io.IOException;

public class ControladorSinOperacion {

    public void clickRegistrar_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/graphic/crearcliente.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickAperturaCuenta_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/graphic/crearcuenta.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickConsignar_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/graphic/consignar.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
