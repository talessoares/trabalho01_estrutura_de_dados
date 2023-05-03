package com.group.controller.category;
import com.group.entities.Category;
import com.group.list.ListCategory;
import com.group.lde.LdeCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerEditCategory {
    
    @FXML
    private Button btnConsultarCategoria;

    @FXML
    private Button btnEditarCategoria;

    @FXML
    private Button btnLimparEditCat;
    
    @FXML
    private ImageView btnVoltarEdirCat;

    @FXML
    private TextField textFieldIdEditCategoria;

    @FXML
    private TableView TableviewEditCat;

    @FXML
    private TextField textFieldNovoNomeCategoria;

    @FXML
    private AnchorPane rootPaneEditCat;

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
        textFieldIdEditCategoria.clear();
        textFieldNovoNomeCategoria.clear();
    }

    @FXML
    void consultarCategoria(){
        if (textFieldIdEditCategoria.getText().isEmpty()){
            alertInterface("ERRO", "O campo ID não pode ser nulo!", AlertType.ERROR);
        } else {
            try {
                int id = Integer.parseInt(textFieldIdEditCategoria.getText());
                // Category category = ListCategory.searchCategory(id);
                // if (category == null){
                //     alertInterface("ERRO", "Categoria não encontrada!", AlertType.ERROR);
                // } else {
                //     textFieldNovoNomeCategoria.setText(category.getName());
                // }
            } catch (Exception e) {
                alertInterface("ERRO", "O campo ID deve ser um número inteiro!", AlertType.ERROR);
            }
        }
    }

    @FXML
    void editarCategoria(){
        if (textFieldIdEditCategoria.getText().isEmpty() || textFieldNovoNomeCategoria.getText().isEmpty()){
            alertInterface("ERRO", "Os campos não podem ser nulos!", AlertType.ERROR);
        } else {
            try {
                int id = Integer.parseInt(textFieldIdEditCategoria.getText());
                // Category category = ListCategory.searchCategory(id);
                // if (category == null){
                //     alertInterface("ERRO", "Categoria não encontrada!", AlertType.ERROR);
                // } else {
                //     category.setName(textFieldNovoNomeCategoria.getText());
                //     alertInterface("SUCESSO", "Categoria editada com sucesso!", AlertType.INFORMATION);
                // }
            } catch (Exception e) {
                alertInterface("ERRO", "O campo ID deve ser um número inteiro!", AlertType.ERROR);
            }
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


