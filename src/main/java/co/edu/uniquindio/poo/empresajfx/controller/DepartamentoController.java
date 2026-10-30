package co.edu.uniquindio.poo.empresajfx.controller;

import co.edu.uniquindio.poo.empresajfx.model.Departamento;
import co.edu.uniquindio.poo.empresajfx.model.Empresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DepartamentoController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TableView<Departamento> tblDepartamentos;
    @FXML private TableColumn<Departamento, String> colCodigo;
    @FXML private TableColumn<Departamento, String> colNombre;

    private Empresa empresa;
    private ObservableList<Departamento> listaObservable;

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        cargarDatos();
    }

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    }

    private void cargarDatos() {
        if (empresa != null) {
            listaObservable = FXCollections.observableArrayList(empresa.getListaDepartamentos());
            tblDepartamentos.setItems(listaObservable);
        }
    }

    @FXML
    private void handleAgregar() {
        Departamento dep = new Departamento(txtCodigo.getText(), txtNombre.getText());
        if (empresa.agregarDepartamento(dep)) {
            cargarDatos();
            limpiarCampos();
        }
    }

    @FXML
    private void handleEliminar() {
        Departamento seleccionado = tblDepartamentos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            empresa.eliminarDepartamento(seleccionado);
            cargarDatos();
        }
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
    }
}
