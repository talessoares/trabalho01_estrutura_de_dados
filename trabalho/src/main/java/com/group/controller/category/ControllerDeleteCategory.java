package com.group.controller.category;
import com.group.controller.ControllerIndex;
import com.group.lde.Node;
import com.group.list.ListCategory;
import com.group.list.ListVehicle;

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

public class ControllerDeleteCategory {
    
    @FXML
    private Button btnExcluirCategoria;

    @FXML
    private Button btnLimparExcCategoria;
    
    @FXML
    private ImageView btnVoltarExcCategoria;

    @FXML
    private TextField textFieldIdExcluirCategoria;

    @FXML
    private AnchorPane rootPane;

    private ListCategory listCategory;

    private ListVehicle listVehicle;

    @FXML
    void initialize() {
        this.listCategory = ControllerIndex.getListCategory();
        this.listVehicle = ControllerIndex.getListVehicle();
    }

    @FXML
    void removeCategory(ActionEvent event) {

        String idCategoria = textFieldIdExcluirCategoria.getText();

        try {

            if(idCategoria == null || idCategoria.trim().isEmpty()) {
                throw new NullPointerException("O campo de ID não pode ser vazio");
            }

            try {
                long idCategoriaLong = Long.parseLong(idCategoria);

                Node node = listVehicle.findByCategory(idCategoriaLong);

                if(node != null) {
                    throw new Exception("Não é possível remover uma categoria que possui veículos");
                }

                if(listCategory.removeCategory(idCategoriaLong)) {
                    alertInterface("Sucesso", "Categoria removida com sucesso", AlertType.INFORMATION);
                } else {
                    alertInterface("Erro", "Categoria não encontrada", AlertType.ERROR);
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("O campo de ID deve ser um número inteiro");
            }
        } catch (NullPointerException e) {
            alertInterface("Erro", e.getMessage(), AlertType.ERROR);
        } catch(Exception e) {
            alertInterface("Erro", e.getMessage(), AlertType.ERROR);
        }
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
    void voltarParaPrincipal(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../views/viewIndex.fxml"));
            Pane cmdPane = (Pane) fxmlLoader.load();

            rootPane.getChildren().clear();
            rootPane.getChildren().add(cmdPane);
        } catch (Exception e) {
            alertInterface("ERRO", "Não foi possível voltar para o menu principal", AlertType.ERROR);
            e.printStackTrace();
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

