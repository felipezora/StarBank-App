package graphic;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Cajero;

public class ControladorCreacion {

    @FXML
    private TextField txtDocuREmpresa;

    @FXML
    private TextField txtTelREmpresa;

    @FXML
    private TextField txtNomREmpresa;

    @FXML
    private TextField txtOcuREmpresa;

    @FXML
    private TextField txtNitEmpresa;

    @FXML
    private TextField txtNomEmpresa;

    @FXML
    private TextField txtSecEmpresa;

    @FXML
    private TextField txtDirEmpresa;

    @FXML
    private TextField txtDocuPer;

    @FXML
    private TextField txtTelPer;

    @FXML
    private TextField txtNomPer;

    @FXML
    private TextField txtOcuPer;

    @FXML
    private TextField txtDirPer;

    public void guardarRegistroEmpresa_action(){
        String doc;
        String nombre;
        String telefono;
        String ocupacion;
        String direccion;
        String nit;
        String nombreEmpresa;
        String sectorComercial;

        doc = txtDocuREmpresa.getText();
        nombre = txtNomREmpresa.getText();
        telefono = txtTelREmpresa.getText();
        ocupacion = txtOcuREmpresa.getText();
        direccion = txtDirEmpresa.getText();
        nit = txtNitEmpresa.getText();
        nombreEmpresa = txtNomEmpresa.getText();
        sectorComercial = txtSecEmpresa.getText();

        Cajero.crearClienteEmpresa(doc, nombre, telefono, ocupacion, direccion, nit, nombreEmpresa, sectorComercial);
    }

    public void guardarRegistroPersona_action(){
        String doc;
        String nombre;
        String telefono;
        String ocupacion;
        String direccion;

        doc = txtDocuPer.getText();
        nombre = txtNomPer.getText();
        telefono = txtTelPer.getText();
        ocupacion = txtOcuPer.getText();
        direccion = txtDirPer.getText();

        Cajero.crearClientePersona(doc, nombre, telefono, ocupacion, direccion);
    }
}
