package com.group.controller.category;

import com.group.controller.ControllerIndex;
import com.group.entities.Category;
import com.group.list.ListCategory;
import com.group.lde.Node;

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

public class ControllerEditCategory {

    @FXML
    private Button btnEditarCategoria;

    @FXML
    private Button btnLimparEditCat;

    @FXML
    private Button btnConsultarCategoria;

    @FXML
    private ImageView btnVoltarEdirCat;

    @FXML
    private AnchorPane rootPaneEditCat;

    @FXML
    private TextField textFieldIdEditCategoria;

    @FXML
    private TextField textFieldNovoNomeCategoria;

    private ListCategory listCategory;

    @FXML
    void initialize() {
        this.listCategory = ControllerIndex.getListCategory();
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
        textFieldIdEditCategoria.setText("");
        textFieldNovoNomeCategoria.setText("");
    }

    @FXML
    void consultarCategoria() {

        String textFieldIdCategory = textFieldIdEditCategoria.getText();

        try {

            long id;

            if(textFieldIdCategory == null || textFieldIdCategory.trim().isEmpty()) {
                throw new Exception("O campo ID não pode ser nulo!");
            }

            try {
                id = Long.parseLong(textFieldIdEditCategoria.getText());
            } catch (NumberFormatException e) {
                throw new Exception("O campo ID deve ser um número inteiro!");
            }

            Node node = listCategory.find(id);

            if(node == null) {
                throw new Exception("Categoria não encontrada!");
            }
            
            Category category = (Category) node.getInfo();
            textFieldNovoNomeCategoria.setText(category.getName());
            
        } catch (Exception e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

    }

    @FXML
    void editarCategoria() {
        String textFieldIdCategory = textFieldIdEditCategoria.getText();
        String nomeCategory = textFieldNovoNomeCategoria.getText();

        try {

            long id;

            if(textFieldIdCategory == null || textFieldIdCategory.trim().isEmpty()) {
                throw new Exception("O campo ID não pode ser nulo!");
            }

            if(nomeCategory == null || nomeCategory.trim().isEmpty()) {
                throw new Exception("O campo Nome não pode ser nulo!");
            }

            try {
                id = Long.parseLong(textFieldIdEditCategoria.getText());
            } catch (NumberFormatException e) {
                throw new Exception("O campo ID deve ser um número inteiro!");
            }

            Node node = listCategory.find(id);

            if(node == null) {
                throw new Exception("Categoria não encontrada!");
            }
            
            Category category = (Category) node.getInfo();
            category.setName(nomeCategory);

            alertInterface("SUCESSO", "Categoria editada com sucesso!", AlertType.INFORMATION);
            
        } catch (Exception e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
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
}
