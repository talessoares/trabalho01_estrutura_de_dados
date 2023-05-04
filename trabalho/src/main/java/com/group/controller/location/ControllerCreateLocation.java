package com.group.controller.location;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import com.group.controller.ControllerIndex;
import com.group.entities.Client;
import com.group.entities.Location;
import com.group.entities.Vehicle;
import com.group.lde.Node;
import com.group.list.ListClient;
import com.group.list.ListLocation;
import com.group.list.ListVehicle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerCreateLocation {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnListar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private DatePicker datePickerDataFinal;

    @FXML
    private DatePicker datePickerDataInicio;

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
    private TextField textFieldCnh;

    @FXML
    private TextField textFieldPlaca;

    private final double VALOR_POR_DIA = 250;

    private ListLocation listLocation;

    private ListVehicle listVehicle;

    private ListClient listClient;

    @FXML
    void initialize() {
        this.listLocation = ControllerIndex.getListLocation();
        this.listVehicle = ControllerIndex.getListVehicle();
        this.listClient = ControllerIndex.getListClient();

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
    void createLocation(ActionEvent event) {

        String cnh = textFieldCnh.getText();
        String placa = textFieldPlaca.getText();

        try {

            LocalDate dataInicio = datePickerDataInicio.getValue();
            LocalDate dataFinal = datePickerDataFinal.getValue();

            if(dataInicio == null || dataFinal == null) {
                throw new NullPointerException("Data de início ou data final não foram preenchidas");
            }

            if(dataInicio.isAfter(dataFinal)) {
                throw new Exception("Data de início não pode ser maior que a data final");
            }

            if(cnh == null || cnh.trim().isEmpty()) {
                throw new NullPointerException("CNH não foi preenchida");
            }

            if(placa == null || placa.trim().isEmpty()) {
                throw new NullPointerException("Placa não foi preenchida");
            }

            if(listLocation.existe(placa)) {
                throw new Exception("Veículo já está locado");
            }

            if(!listClient.existeByCNH(cnh)) {
                throw new NullPointerException("CNH não encontrada");
            }

            if(!listVehicle.existe(placa)) {
                throw new NullPointerException("Placa não encontrada");
            }

            Client client = (Client) listClient.findByCNH(cnh).getInfo();

            Vehicle vehicle = (Vehicle) listVehicle.find(placa).getInfo();

            Calendar dataInicioCalendar = Calendar.getInstance();
            dataInicioCalendar.setTime(Date.valueOf(dataInicio));
            
            Calendar dataFinalCalendar = Calendar.getInstance();
            dataFinalCalendar.setTime(Date.valueOf(dataFinal));

            double dias = (dataFinalCalendar.getTimeInMillis() - dataInicioCalendar.getTimeInMillis()) / (1000 * 60 * 60 * 24);
            double valorParaPagar = dias * VALOR_POR_DIA;

            Location location = new Location(client, vehicle, dataInicioCalendar, dataFinalCalendar, valorParaPagar);
            listLocation.addLocationAtEnd(location);

            alertInterface("SUCESSO", "Locação criada com sucesso!\nO valor a ser pago será de: " + valorParaPagar, AlertType.INFORMATION);

            listarVeiculosDisponiveis(event);
        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }
        
    }

    @FXML
    void listarVeiculosDisponiveis(ActionEvent event) {
        String content = listVehicle.getListFromBeginning();
        String[] breakContent = content.split("\n");

        tableViewVehicle.getItems().clear();

        for(String line : breakContent) {

            String placa = line.split(";")[0].split(":")[1];

            Node node = listLocation.find(placa);

            if(node == null) {
                node = listVehicle.find(placa);
                Vehicle vehicle = (Vehicle) node.getInfo();

                tableViewVehicle.getItems().add(vehicle);
            }
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
        textFieldCnh.setText("");
        textFieldPlaca.setText("");
        datePickerDataInicio.setValue(null);
        datePickerDataFinal.setValue(null);
        
    }

}
