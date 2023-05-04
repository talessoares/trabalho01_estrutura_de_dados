package com.group.controller.client;

import com.group.controller.ControllerIndex;
import com.group.entities.Client;
import com.group.list.ListClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerVisualizationClient {

    @FXML
    private TableView<Client> tableviewVisuClient;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnLimparEditCat;

    @FXML
    private Button btnImprimirInicio;

    @FXML
    private Button btnImprimirFinal;

    @FXML
    private ImageView btnVoltarEdirCat;

    @FXML
    private AnchorPane rootPaneEditCat;

    @FXML
    private TableColumn<Client, String> tableColumnNome;

    @FXML
    private TableColumn<Client, String> tableColumnTelefone;

    @FXML
    private TableColumn<Client, String> tableColumnCNH;

    @FXML
    private TableColumn<Client, String> tableColumnCpf;

    @FXML
    private TextField textFieldCpf;

    private ListClient listClient;

    @FXML
    void initialize() {
        this.listClient = ControllerIndex.getListClient();

        tableColumnNome.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
        tableColumnCNH.setCellValueFactory(new PropertyValueFactory<Client, String>("cnh"));
        tableColumnCpf.setCellValueFactory(new PropertyValueFactory<Client, String>("cpf"));
    }

    @FXML
    void imprimirListaInicio(ActionEvent event) {

        if(listClient.isEmpty()) {
            alertInterface("Lista Vazia", "A lista está vazia, não há o que imprimir.", AlertType.INFORMATION);
            return;
        }

        String content = listClient.getListFromBeginning();
        String[] contentBreak = content.split("\n");

        ObservableList<Client> list = FXCollections.observableArrayList();

        for(String line : contentBreak) {
            
            String name = line.split(";")[0].split(":")[1];
            String cnh = line.split(";")[1].split(":")[1];
            String phone = line.split(";")[2].split(":")[1];
            String cpf = line.split(";")[3].split(":")[1];

            Client client = new Client(name, cnh, phone, cpf);
            list.add(client);
        }

        tableviewVisuClient.getItems().clear();
        tableviewVisuClient.setItems(list);
    }

    @FXML
    void imprimirListaFinal(ActionEvent event) {

        if(listClient.isEmpty()) {
            alertInterface("Lista Vazia", "A lista está vazia, não há o que imprimir.", AlertType.INFORMATION);
            return;
        }

        String content = listClient.getListFromEnd();
        String[] contentBreak = content.split("\n");

        ObservableList<Client> list = FXCollections.observableArrayList();

        for(String line : contentBreak) {
            
            String name = line.split(";")[0].split(":")[1];
            String cnh = line.split(";")[1].split(":")[1];
            String phone = line.split(";")[2].split(":")[1];
            String cpf = line.split(";")[3].split(":")[1];

            Client client = new Client(name, cnh, phone, cpf);
            list.add(client);
        }

        tableviewVisuClient.getItems().clear();
        tableviewVisuClient.setItems(list);
    }

    @FXML
    void consultClient(ActionEvent event) {
        String cpf = textFieldCpf.getText();

        try {

            if(cpf == null || cpf.trim().isEmpty()) {
                throw new NullPointerException("Campo categoria não pode ser vazio");
            }

            if(!listClient.existe(cpf)) {
                throw new NullPointerException("Cliente não encontrado");
            }

            Client client = (Client) listClient.find(cpf).getInfo();

            tableviewVisuClient.getItems().clear();
            tableviewVisuClient.getItems().add(client);
            
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

            rootPaneEditCat.getChildren().clear();
            rootPaneEditCat.getChildren().add(cmdPane);
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
        btnVoltarEdirCat.setImage(new Image("com/group/views/images/pngVoltarHover.png"));
        btnVoltarEdirCat.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltarEdirCat.setImage(new Image("com/group/views/images/pngVoltar.png"));
        btnVoltarEdirCat.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(ActionEvent event) {
        textFieldCpf.setText("");
    }

}
