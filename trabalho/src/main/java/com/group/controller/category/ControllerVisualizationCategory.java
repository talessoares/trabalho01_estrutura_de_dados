package com.group.controller.category;

import com.group.controller.ControllerIndex;
import com.group.entities.Category;
import com.group.list.ListCategory;

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

public class ControllerVisualizationCategory {

    @FXML
    private TableView<Category> tableviewVisuCat;

    @FXML
    private Button btnConsultarCat;

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
    private TableColumn<Category, Long> tableColumnIdCategoria;

    @FXML
    private TableColumn<Category, String> tableColumnNomeCategoria;

    @FXML
    private TextField textFieldIdEditCategoria;

    private ListCategory listCategory;

    @FXML
    void initialize() {
        this.listCategory = ControllerIndex.getListCategory();

        tableColumnIdCategoria.setCellValueFactory(new PropertyValueFactory<Category, Long>("id"));
        tableColumnNomeCategoria.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
    }

    @FXML
    void consultCategory(ActionEvent event) {

        String idCategoria = textFieldIdEditCategoria.getText();

        try {

            if (idCategoria == null || idCategoria.trim().isEmpty()) {
                throw new NullPointerException("Campo categoria não pode ser vazio");
            }

            try {
                long id = Long.parseLong(idCategoria);

                if (!listCategory.existe(id)) {
                    throw new NullPointerException("Categoria não encontrada");
                }

                Category category = (Category) listCategory.find(id).getInfo();

                tableviewVisuCat.getItems().clear();
                tableviewVisuCat.getItems().add(category);

            } catch (NumberFormatException e) {
                alertInterface("ERRO", "Campo categoria deve ser um número", AlertType.ERROR);
            }

        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO inesperado", e.getMessage(), AlertType.ERROR);
        }

    }

    @FXML
    void imprimirListaInicio(ActionEvent event) {

        if (listCategory.isEmpty()) {
            alertInterface("Lista Vazia", "A lista está vazia, não há o que imprimir.", AlertType.INFORMATION);
            return;
        }

        String content = listCategory.getListFromBeginning();
        String[] breakContent = content.split("\n");

        tableviewVisuCat.getItems().clear();

        for (String line : breakContent) {
            String id = line.split(";")[0].split(":")[1];
            String name = line.split(";")[1].split(":")[1];

            Category category = new Category(name, Long.parseLong(id));

            tableviewVisuCat.getItems().add(category);
        }
    }

    @FXML
    void imprimirListaFinal(ActionEvent event) {

        if (listCategory.isEmpty()) {
            alertInterface("Lista Vazia", "A lista está vazia, não há o que imprimir.", AlertType.INFORMATION);
            return;
        }

        String content = listCategory.getListFromEnd();
        String[] breakContent = content.split("\n");

        tableviewVisuCat.getItems().clear();

        for (String line : breakContent) {
            String id = line.split(";")[0].split(":")[1];
            String name = line.split(";")[1].split(":")[1];

            Category category = new Category(name, Long.parseLong(id));

            tableviewVisuCat.getItems().add(category);
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
        textFieldIdEditCategoria.setText("");
    }

}
