package com.group.controller.client;

import com.group.controller.ControllerIndex;
import com.group.entities.Client;
import com.group.list.ListClient;
import com.group.list.ListLocation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerDeleteClient {

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnRemover;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCPF;

    private ListClient listClient;

    private ListLocation listLocation;

    @FXML
    void initialize() {
        this.listClient = ControllerIndex.getListClient();
        this.listLocation = ControllerIndex.getListLocation();
    }

    @FXML
    void removeClient(ActionEvent event) {
        String cpf = textFieldCPF.getText();

        try {

            if(cpf == null || cpf.trim().isEmpty()) {
                throw new NullPointerException("Cpf não pode ser vazio");
            }


            if(!listClient.existe(cpf)) {
                throw new NullPointerException("Cliente não encontrado");
            }

            Client client = (Client) listClient.find(cpf).getInfo();

            String cnh = client.getCnh();

            if(listLocation.existeByCNH(cnh)) {
                throw new NullPointerException("Cliente possui locação ativa");
            }

            if(listClient.removeClient(cpf)) {
                alertInterface("Sucesso", "Cliente removido com sucesso", AlertType.INFORMATION);
                limparCampos(event);
            } else {
                throw new NullPointerException("Cliente não encontrado");
            }

        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO inesperado", e.getMessage(), AlertType.ERROR);
        }
        
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
        textFieldCPF.setText("");
    }
}
