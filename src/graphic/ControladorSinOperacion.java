package graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class ControladorSinOperacion {

    public void clickCliente_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/graphic/cliente.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickCajero_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/graphic/cajero.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void clickRegistrar_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/graphic/crearcliente.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
