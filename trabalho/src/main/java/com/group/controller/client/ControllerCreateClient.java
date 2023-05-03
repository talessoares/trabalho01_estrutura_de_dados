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

public class ControllerCreateClient {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCNH;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldTelefone;

    private ListClient listClient;

    @FXML
    void initialize() {
        this.listClient = ControllerIndex.getListClient();
    }

    @FXML
    void createClient(ActionEvent event) {
        String nome = textFieldNome.getText();
        String cpf = textFieldCPF.getText();
        String cnh = textFieldCNH.getText();
        String telefone = textFieldTelefone.getText();

        try {

            if(nome == null || nome.trim().isEmpty()) {
                throw new NullPointerException("Nome não pode ser vazio");
            }

            if(cpf == null || cpf.trim().isEmpty()) {
                throw new NullPointerException("CPF não pode ser vazio");
            }

            if(cnh == null || cnh.trim().isEmpty()) {
                throw new NullPointerException("CNH não pode ser vazio");
            }

            if(telefone == null || telefone.trim().isEmpty()) {
                throw new NullPointerException("Telefone não pode ser vazio");
            }

            Client client = null;

            Node node = listClient.find(cpf);

            if(node != null) {
                throw new Exception("Cliente já cadastrado");
            }

            client = new Client(nome, cnh, telefone, cpf);
            listClient.addClientAtEnd(client);
            
            alertInterface("Sucesso", "Cliente cadastrado com sucesso!", AlertType.INFORMATION);

        } catch (NullPointerException e) {
            alertInterface("Erro", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("Erro", e.getMessage(), AlertType.ERROR);
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
        textFieldCNH.clear();
        textFieldCPF.clear();
        textFieldNome.clear();
        textFieldTelefone.clear();
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
