package com.group.controller.client;

import com.group.controller.ControllerIndex;
import com.group.entities.Client;
import com.group.lde.Node;
import com.group.list.ListClient;

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

public class ControllerEditClient {

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnConsultarCliente;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldEditCPF;

    @FXML
    private TextField textFieldEditNome;

    @FXML
    private TextField textFieldEditCNH;

    @FXML
    private TextField textFieldEditTelefone;

    private ListClient listClient;

    @FXML
    void initialize() {
        this.listClient = ControllerIndex.getListClient();
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
        textFieldEditCPF.setText("");
    }


    @FXML
    void editClient(ActionEvent event) {
        String cpf = textFieldEditCPF.getText();
        String name = textFieldEditNome.getText();
        String cnh = textFieldEditCNH.getText();
        String phone = textFieldEditTelefone.getText();

        try {

            if(cpf == null || cpf.trim().isEmpty()) {
                throw new NullPointerException("Cpf não pode ser vazio");
            }

            if(name == null || name.trim().isEmpty()) {
                throw new NullPointerException("Nome não pode ser vazio");
            }

            if(cnh == null || cnh.trim().isEmpty()) {
                throw new NullPointerException("CNH não pode ser vazio");
            }

            if(phone == null || phone.trim().isEmpty()) {
                throw new NullPointerException("Telefone não pode ser vazio");
            }

            Node node = listClient.find(cpf);

            if(node == null) {
                throw new NullPointerException("Cliente não encontrado");
            }

            Client client = (Client) node.getInfo();

            client.setName(name);
            client.setCnh(cnh);
            client.setPhone(phone);

            alertInterface("Sucesso", "Cliente editado com sucesso", AlertType.INFORMATION);

        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO inesperado", e.getMessage(), AlertType.ERROR);
        }

        
    }

    @FXML
    void consultClient(ActionEvent event) {
        String cpf = textFieldEditCPF.getText();

        try {

            if(cpf == null || cpf.trim().isEmpty()) {
                throw new NullPointerException("Cpf não pode ser vazio");
            }

            Node node = listClient.find(cpf);

            if(node == null) {
                throw new NullPointerException("Cliente não encontrado");
            }

            Client client = (Client) node.getInfo();

            textFieldEditNome.setText(client.getName());
            textFieldEditCNH.setText(client.getCnh());
            textFieldEditTelefone.setText(client.getPhone());

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
}
