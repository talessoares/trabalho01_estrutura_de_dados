package com.group.controller.location;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import com.group.controller.ControllerIndex;
import com.group.entities.Client;
import com.group.entities.Location;
import com.group.entities.Vehicle;
import com.group.lde.Node;
import com.group.list.ListClient;
import com.group.list.ListLocation;
import com.group.list.ListVehicle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerEditLocation {

    @FXML
    private Button btnConsult;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSalvar;

    @FXML
    private ImageView btnVoltar;

    @FXML
    private DatePicker datePickerDataFinal;

    @FXML
    private DatePicker datePickerDataInicio;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField textFieldCnh;

    @FXML
    private TextField textFieldPlaca;

    private final double valorPorDia = 250.0;

    private ListLocation listLocation;

    private ListClient listClient;

    private ListVehicle listVehicle;

    @FXML
    void initialize() {
        this.listLocation = ControllerIndex.getListLocation();
        this.listClient = ControllerIndex.getListClient();
        this.listVehicle = ControllerIndex.getListVehicle();
    }

    @FXML
    void consultLocation(ActionEvent event) {

        String placa = textFieldPlaca.getText();

        try {

            Calendar data = null;
            Instant instant = null;
            LocalDate dataLocalDate = null;

            if(placa == null || placa.trim().isEmpty()) {
                throw new NullPointerException("O campo placa não pode ser vazio");
            }

            Node node = listLocation.find(placa);

            if(node == null) {
                throw new Exception("Placa não encontrada");
            }

            Location location = (Location) node.getInfo();

            textFieldCnh.setText(location.getClient().getCnh());

            data = location.getLocationDate();

            instant = data.toInstant();
            dataLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

            datePickerDataInicio.setValue(dataLocalDate);

            data = location.getDevolutionDate();

            instant = data.toInstant();
            dataLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

            datePickerDataFinal.setValue(dataLocalDate);

        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        }

    }

    @FXML
    void saveLocation(ActionEvent event) {

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

            Node node = listLocation.find(placa);

            if(node == null) {
                throw new Exception("Veículo não está locado");
            }

            node = listClient.findByCNH(cnh);

            if(node == null) {
                throw new NullPointerException("CNH não encontrada");
            }

            Client client = (Client) node.getInfo();

            node = listVehicle.find(placa);

            if(node == null) {
                throw new NullPointerException("Placa não encontrada");
            }

            Vehicle vehicle = (Vehicle) node.getInfo();

            Calendar dataInicioCalendar = Calendar.getInstance();
            dataInicioCalendar.setTime(Date.valueOf(dataInicio));
            
            Calendar dataFinalCalendar = Calendar.getInstance();
            dataFinalCalendar.setTime(Date.valueOf(dataFinal));

            double dias = (dataFinalCalendar.getTimeInMillis() - dataInicioCalendar.getTimeInMillis()) / (1000 * 60 * 60 * 24);
            double valorParaPagar = dias * valorPorDia;

            node = listLocation.find(placa);

            if(node == null) {
                throw new Exception("Locação não encontrada");
            }

            Location location = (Location) node.getInfo();

            location.setClient(client);
            location.setVehicle(vehicle);
            location.setLocationDate(dataInicioCalendar);
            location.setDevolutionDate(dataFinalCalendar);
            location.setValue(valorParaPagar);

            System.out.println(listLocation.getListFromBeginning());

            alertInterface("SUCESSO", "Locação criada com sucesso!\nO valor a ser pago será de: " + valorParaPagar, AlertType.INFORMATION);

        } catch (NullPointerException e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO", e.getMessage(), AlertType.ERROR);
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
        textFieldPlaca.setText("");        
    }

}
