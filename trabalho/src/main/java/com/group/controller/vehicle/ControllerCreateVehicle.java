package com.group.controller.vehicle;

import com.group.controller.ControllerIndex;
import com.group.entities.Category;
import com.group.entities.Vehicle;
import com.group.lde.Node;
import com.group.list.ListCategory;
import com.group.list.ListVehicle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerCreateVehicle {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldAno;

    @FXML
    private TextField textFieldAssentos;

    @FXML
    private TextField textFieldCategoria;

    @FXML
    private TextField textFieldMarca;

    @FXML
    private TextField textFieldModelo;

    @FXML
    private TextField textFieldPlaca;

    @FXML
    private TextField textFieldPotencia;

    private ListVehicle listVehicle;

    private ListCategory listCategory;

    @FXML
    void initialize() {
        this.listVehicle = ControllerIndex.getListVehicle();
        this.listCategory = ControllerIndex.getListCategory();
    }

    @FXML
    void createVehicle(ActionEvent event) {

        String placa = textFieldPlaca.getText();
        String marca = textFieldMarca.getText();
        String modelo = textFieldModelo.getText();
        String ano = textFieldAno.getText();
        String idCategoria = textFieldCategoria.getText();
        String potencia = textFieldPotencia.getText();
        String assentos = textFieldAssentos.getText();

        try {

            if(placa == null || placa.trim().isEmpty()) {
                throw new NullPointerException("Placa não pode ser vazio");
            }

            if(marca == null || marca.trim().isEmpty()) {
                throw new NullPointerException("Marca não pode ser vazio");
            }

            if(modelo == null || modelo.trim().isEmpty()) {
                throw new NullPointerException("Modelo não pode ser vazio");
            }

            if(ano == null || ano.trim().isEmpty()) {
                throw new NullPointerException("Ano não pode ser vazio");
            }

            if(idCategoria == null || idCategoria.trim().isEmpty()) {
                throw new NullPointerException("Categoria não pode ser vazio");
            }

            if(potencia == null || potencia.trim().isEmpty()) {
                throw new NullPointerException("Potencia não pode ser vazio");
            }

            if(assentos == null || assentos.trim().isEmpty()) {
                throw new NullPointerException("Assentos não pode ser vazio");
            }

            long idLongCategoria = 0;
            int anoInt = 0;
            int potenciaInt = 0;
            int assentosInt = 0;

            try {
                idLongCategoria = Long.parseLong(idCategoria);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Categoria deve ser um número");
            }

            try {
                anoInt = Integer.parseInt(ano);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Ano deve ser um número");
            }

            try {
                potenciaInt = Integer.parseInt(potencia);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Potencia deve ser um número");
            }

            try {
                assentosInt = Integer.parseInt(assentos);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Assentos deve ser um número");
            }
           

            Node node = listCategory.find(idLongCategoria);

            if(node == null) {
                throw new NullPointerException("Categoria não encontrada");
            }

            Category category = (Category) node.getInfo();

            node = listVehicle.find(placa);

            if(node != null) {
                throw new NullPointerException("Veículo já cadastrado");
            }

            Vehicle vehicle = new Vehicle(placa, modelo, anoInt, potenciaInt, assentosInt, marca, category);
            listVehicle.addVehicleAtEnd(vehicle);
            
            alertInterface("Sucesso", "Veículo cadastrado com sucesso", AlertType.INFORMATION);
        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO inesperado", e.getMessage(), AlertType.ERROR);
        }

    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("com/group/views/images/pngVoltarHover.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltar.setImage(new Image("com/group/views/images/pngVoltar.png"));
        btnVoltar.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(ActionEvent event) {
        textFieldAno.setText("");
        textFieldAssentos.setText("");
        textFieldCategoria.setText("");
        textFieldMarca.setText("");
        textFieldModelo.setText("");
        textFieldPlaca.setText("");
        textFieldPotencia.setText("");
    }

    @FXML
    void voltarParaPrincipal(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../views/viewIndex.fxml"));
            Pane cmdPane = (Pane) fxmlLoader.load();

            rootPane.getChildren().clear();
            rootPane.getChildren().add(cmdPane);
        } catch (Exception e) {
            alertInterface("ERRO", "Não foi possível voltar para o menu principal", AlertType.ERROR);
        }
    }

    void alertInterface(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
