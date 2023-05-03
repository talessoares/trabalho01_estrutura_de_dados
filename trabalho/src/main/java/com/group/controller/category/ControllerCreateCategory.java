package com.group.controller.category;
import com.group.controller.ControllerIndex;
import com.group.entities.Category;
import com.group.list.ListCategory;
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

public class ControllerCreateCategory {
    
    @FXML
    private Button btnCriarCategoria;

    @FXML
    private Button btnLimparCategoria;

    @FXML
    private ImageView btnVoltarCategoria;

    @FXML
    private TextField textFieldNomeCategoria;

    @FXML
    private AnchorPane rootPaneCriaCat;

    private ListCategory listCategory;

    @FXML
    void initialize() {
        this.listCategory = ControllerIndex.getListCategory();
    }

    @FXML
    void createClient(ActionEvent event) {
        String nomeCat = textFieldNomeCategoria.getText();

        try {
            if(nomeCat == null || nomeCat.trim().isEmpty()) {
                throw new NullPointerException("Nome não pode ser vazio");
            }

            Category category = new Category(nomeCat);
            listCategory.addCategoryAtEnd(category);
            alertInterface("Sucesso", "Categoria criada com sucesso", AlertType.INFORMATION);

        } catch (NullPointerException e) {
            alertInterface("Erro", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("Erro", e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    void hoverBtnVoltar(MouseEvent event) {
        btnVoltarCategoria.setImage(new Image("com/group/views/images/pngVoltarHover.png"));
        btnVoltarCategoria.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void notHoverBtnVoltar(MouseEvent event) {
        btnVoltarCategoria.setImage(new Image("com/group/views/images/pngVoltar.png"));
        btnVoltarCategoria.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void limparCampos(ActionEvent event) {
        textFieldNomeCategoria.clear();
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
