package com.group.controller.vehicle;

import com.group.controller.ControllerIndex;
import com.group.entities.Category;
import com.group.entities.Vehicle;
import com.group.lde.Node;
import com.group.list.ListVehicle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerVisualizationVehicle {

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnImprimirFinal;

    @FXML
    private Button btnImprimirInicio;

    @FXML
    private Button btnLimpar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableColumn<Vehicle, Integer> tableColumnAno;

    @FXML
    private TableColumn<Vehicle, Integer> tableColumnAssentos;

    @FXML
    private TableColumn<Vehicle, Long> tableColumnIdCategoria;

    @FXML
    private TableColumn<Vehicle, String> tableColumnMarca;

    @FXML
    private TableColumn<Vehicle, String> tableColumnModelo;

    @FXML
    private TableColumn<Vehicle, String> tableColumnNomeCategoria;

    @FXML
    private TableColumn<Vehicle, String> tableColumnPlaca;

    @FXML
    private TableColumn<Vehicle, Integer> tableColumnPotencia;

    @FXML
    private TableView<Vehicle> tableViewVehicle;

    @FXML
    private TextField textFieldPlaca;

    private ListVehicle listVehicle;

    @FXML
    void initialize() {
        this.listVehicle = ControllerIndex.getListVehicle();

        tableColumnAno.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getYear()));
        tableColumnAssentos.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getSeats()));
        tableColumnMarca.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getBrand()));
        tableColumnModelo.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getModel()));
        tableColumnPlaca.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getPlate()));
        tableColumnPotencia.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getHorsePower()));
        tableColumnNomeCategoria.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getCategory().getName()));
        tableColumnIdCategoria.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getCategory().getId()));
    }

    @FXML
    void consultVehicle(ActionEvent event) {
        String placa = textFieldPlaca.getText();

        try {

            if(placa == null || placa.trim().isEmpty()) {
                throw new NullPointerException("Campo placa não pode ser vazio");
            }

            Node node = listVehicle.find(placa);

            if(node == null) {
                throw new NullPointerException("Veiculo não encontrado");
            }

            Vehicle client = (Vehicle) node.getInfo();

            tableViewVehicle.getItems().clear();
            tableViewVehicle.getItems().add(client);
            
        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO inesperado", e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    void imprimirListaInicio(ActionEvent event) {
        String content = listVehicle.getListFromBeginning();
        String[] contentBreak = content.split("\n");

        ObservableList<Vehicle> list = FXCollections.observableArrayList();

        for(String line : contentBreak) {
            String placa = line.split(";")[0].split(":")[1];
            String modelo = line.split(";")[1].split(":")[1];
            String ano = line.split(";")[2].split(":")[1];
            String potencia = line.split(";")[3].split(":")[1];
            String assentos = line.split(";")[4].split(":")[1];
            String marca = line.split(";")[5].split(":")[1];
            String idCategoria = line.split(";")[6].split(":")[2];
            String nomeCategoria = line.split(";")[7].split(":")[1];

            int anoInt = Integer.parseInt(ano);
            int potenciaInt = Integer.parseInt(potencia);
            int assentosInt = Integer.parseInt(assentos);
            long idCategoriaInt = Long.parseLong(idCategoria);

            Category category = new Category(nomeCategoria, idCategoriaInt);

            Vehicle vehicle = new Vehicle(placa, modelo, anoInt, potenciaInt, assentosInt, marca, category);

            list.add(vehicle);
        }

        tableViewVehicle.getItems().clear();
        tableViewVehicle.setItems(list);
    }

    @FXML
    void imprimirListaFinal(ActionEvent event) {
        String content = listVehicle.getListFromEnd();
        String[] contentBreak = content.split("\n");

        ObservableList<Vehicle> list = FXCollections.observableArrayList();

        for(String line : contentBreak) {
            String placa = line.split(";")[0].split(":")[1];
            String modelo = line.split(";")[1].split(":")[1];
            String ano = line.split(";")[2].split(":")[1];
            String potencia = line.split(";")[3].split(":")[1];
            String assentos = line.split(";")[4].split(":")[1];
            String marca = line.split(";")[5].split(":")[1];
            String idCategoria = line.split(";")[6].split(":")[2];
            String nomeCategoria = line.split(";")[7].split(":")[1];

            int anoInt = Integer.parseInt(ano);
            int potenciaInt = Integer.parseInt(potencia);
            int assentosInt = Integer.parseInt(assentos);
            long idCategoriaInt = Long.parseLong(idCategoria);

            Category category = new Category(nomeCategoria, idCategoriaInt);

            Vehicle vehicle = new Vehicle(placa, modelo, anoInt, potenciaInt, assentosInt, marca, category);

            list.add(vehicle);
        }

        tableViewVehicle.getItems().clear();
        tableViewVehicle.setItems(list);
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
      
    }

}
