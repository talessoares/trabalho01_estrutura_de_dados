package com.group.controller.vehicle;

import com.group.controller.ControllerIndex;
import com.group.list.ListLocation;
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

public class ControllerDeleteVehicle {

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnRemover;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldPlaca;

    private ListVehicle listVehicle;

    private ListLocation listLocation;

    @FXML
    void initialize() {
        this.listVehicle = ControllerIndex.getListVehicle();
        this.listLocation = ControllerIndex.getListLocation();
    }

    @FXML
    void removeVehicle(ActionEvent event) {
        String placa = textFieldPlaca.getText();

        try {

            if(placa == null || placa.trim().isEmpty()) {
                throw new NullPointerException("Placa não pode ser vazio");
            }

            if(listLocation.existe(placa)) {
                throw new Exception("Veículo está alocado");
            }

            if(listVehicle.removeVehicle(placa)) {
                alertInterface("SUCESSO", "Veículo removido com sucesso", AlertType.INFORMATION);
            } else {
                alertInterface("ERRO", "Veículo não encontrado", AlertType.ERROR);
            }

        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
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
        textFieldPlaca.setText("");
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
