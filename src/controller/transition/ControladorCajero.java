package controller.transition;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class ControladorCajero {

    public void clickRegistrarCliente_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/opmanagement/crearcliente.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickAperturaCuenta_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/opmanagement/crearcuenta.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickConsignar_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/opmanagement/consignar.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickRetirar_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/opmanagement/retirar.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickDesactivacion_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/opmanagement/desactivar.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
