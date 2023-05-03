package com.group.controller.location;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.group.controller.ControllerIndex;
import com.group.entities.Location;
import com.group.entities.Vehicle;
import com.group.lde.Node;
import com.group.list.ListLocation;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class ControllerVisualizationLocation {

    @FXML
    private Button btnConsult;

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
    private TableColumn<Location, String> tableColumnCpf;

    @FXML
    private TableColumn<Location, Calendar> tableColumnDataDevolucao;

    @FXML
    private TableColumn<Location, Double> tableColumnValor;

    @FXML
    private TableColumn<Location, Calendar> tableColumnDataLocacao;

    @FXML
    private TableColumn<Location, String> tableColumnPlaca;

    @FXML
    private TableView<Location> tableViewLocation;

    @FXML
    private TextField textFieldPlaca;

    private ListLocation listLocation;

    @FXML
    void initialize() {
        this.listLocation = ControllerIndex.getListLocation();

        tableColumnCpf.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getClient().getCpf()));
        tableColumnDataDevolucao.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getDevolutionDate()));
        tableColumnPlaca.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getVehicle().getPlate()));
        tableColumnValor.setCellValueFactory(dadosTabela -> new SimpleObjectProperty<>(dadosTabela.getValue().getValue()));

        tableColumnDataLocacao
                .setCellValueFactory(new Callback<CellDataFeatures<Location, Calendar>, ObservableValue<Calendar>>() {
                    @Override
                    public ObservableValue<Calendar> call(CellDataFeatures<Location, Calendar> dadosTabela) {
                        Calendar calendar = dadosTabela.getValue().getLocationDate();
                        return new SimpleObjectProperty<Calendar>(calendar);
                    }
                });

        tableColumnDataLocacao
                .setCellFactory(new Callback<TableColumn<Location, Calendar>, TableCell<Location, Calendar>>() {
                    @Override
                    public TableCell<Location, Calendar> call(TableColumn<Location, Calendar> column) {
                        return new TableCell<Location, Calendar>() {
                            private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                            @Override
                            protected void updateItem(Calendar item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(sdf.format(item.getTime()));
                                }
                            }
                        };
                    }
                });

        tableColumnDataDevolucao
                .setCellValueFactory(new Callback<CellDataFeatures<Location, Calendar>, ObservableValue<Calendar>>() {
                    @Override
                    public ObservableValue<Calendar> call(CellDataFeatures<Location, Calendar> dadosTabela) {
                        Calendar calendar = dadosTabela.getValue().getDevolutionDate();
                        return new SimpleObjectProperty<Calendar>(calendar);
                    }
                });

        tableColumnDataDevolucao
                .setCellFactory(new Callback<TableColumn<Location, Calendar>, TableCell<Location, Calendar>>() {
                    @Override
                    public TableCell<Location, Calendar> call(TableColumn<Location, Calendar> column) {
                        return new TableCell<Location, Calendar>() {
                            private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                            @Override
                            protected void updateItem(Calendar item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(sdf.format(item.getTime()));
                                }
                            }
                        };
                    }
                });
    }

    @FXML
    void consultLocation(ActionEvent event) {

        String placa = textFieldPlaca.getText();

        try {

            if(placa == null || placa.trim().isEmpty()) {
                throw new NullPointerException("Placa não pode ser vazia");
            }

            Node node = listLocation.find(placa);

            if(node == null) {
                throw new NullPointerException("Não foi possível encontrar a locação");
            }

            Location location = (Location) node.getInfo();

            ObservableList<Location> observableList = FXCollections.observableArrayList();
            observableList.add(location);

            tableViewLocation.setItems(observableList);
        } catch (NullPointerException e) {
            alertInterface("ERRO", "Placa não pode ser vazia", AlertType.ERROR);
        } catch (Exception e) {
            alertInterface("ERRO", "Não foi possível consultar a locação", AlertType.ERROR);
        }

    }

    @FXML
    void imprimirListaFinal(ActionEvent event) {
        String content = listLocation.getListFromEnd();
        String[] contentBreak = content.split("\n");

        ObservableList<Location> list = FXCollections.observableArrayList();

        for(String line : contentBreak) {
            String placa = line.split(";")[1].split(":")[1];

            Location location = (Location) listLocation.find(placa).getInfo();

            list.add(location);
        }

        tableViewLocation.getItems().clear();
        tableViewLocation.setItems(list);
    }

    @FXML
    void imprimirListaInicio(ActionEvent event) {
        String content = listLocation.getListFromBeginning();
        String[] contentBreak = content.split("\n");

        ObservableList<Location> list = FXCollections.observableArrayList();

        for(String line : contentBreak) {
            String placa = line.split(";")[1].split(":")[1];

            Location location = (Location) listLocation.find(placa).getInfo();

            list.add(location);
        }

        tableViewLocation.getItems().clear();
        tableViewLocation.setItems(list);
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
