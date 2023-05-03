package com.group.controller.category;
import com.group.entities.Category;
import com.group.list.ListCategory;
import com.group.lde.LdeCategory;
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
    private Button btnExcluirCategoria;

    @FXML
    private Button btnLimparExcCategoria;
    
    @FXML
    private ImageView btnVoltarExcCategoria;

    @FXML
    private TextField textFieldIdExcluirCategoria;

    @FXML
    private AnchorPane rootPaneCriaCat;

    @FXML
    void initialize() {
        // ALTERAR ISSO, PUXAR DO MENU PRINCIPAL DE FORMA ESTÁTICA
        this.ListCategory = new ListCategory();
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltarExcCategoria.setImage(new Image("com/group/views/images/pngVoltarHover.png"));
        btnVoltarExcCategoria.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltarExcCategoria.setImage(new Image("com/group/views/images/pngVoltar.png"));
        btnVoltarExcCategoria.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(ActionEvent event) {
        textFieldIdExcluirCategoria.clear();
    }


    @FXML
    void removeCategory(ActionEvent event) {
        if (textFieldIdExcluirCategoria == null){
            alertInterface("ERRO", "O campo CPF não pode ser nulo!", AlertType.ERROR);
        }

        
    }

    @FXML
    void voltarParaPrincipal(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../views/viewIndex.fxml"));
            Pane cmdPane = (Pane) fxmlLoader.load();

            rootPaneCriaCat.getChildren().clear();
            rootPaneCriaCat.getChildren().add(cmdPane);
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


