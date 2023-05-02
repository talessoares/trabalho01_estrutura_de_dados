package com.group.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerIndex {

    @FXML
    private Button btnAdicionaCategoria;

    @FXML
    private Button btnAdicionaCliente;

    @FXML
    private Button btnAdicionaLocacao;

    @FXML
    private Button btnAdicionaVeiculo;

    @FXML
    private Button btnAlteraInformacoesCategoria;

    @FXML
    private Button btnAlteraInformacoesLocacao;

    @FXML
    private Button btnAlteraInformacoesVeiculo;

    @FXML
    private Button btnAlterarInformacoesCliente;

    @FXML
    private Button btnCategoriasExpandir;

    @FXML
    private Button btnClientesExpandir;

    @FXML
    private Button btnLocacoesExpandir;

    @FXML
    private Button btnRemoveCategoria;

    @FXML
    private Button btnRemoveCliente;

    @FXML
    private Button btnRemoveLocacao;

    @FXML
    private Button btnRemoveVeiculo;

    @FXML
    private Button btnVeiculosExpandir;

    @FXML
    private Button btnVisualizaInformacoesCategoria;

    @FXML
    private Button btnVisualizaInformacoesCliente;

    @FXML
    private Button btnVisualizaInformacoesLocacao;

    @FXML
    private Button btnVisualizaInformacoesVeiculo;

    @FXML
    private Pane paneMenuCategoriasExpandido;

    @FXML
    private Pane paneMenuCategoriasFechado;

    @FXML
    private Pane paneMenuClientesExpandido;

    @FXML
    private Pane paneMenuClientesFechado;

    @FXML
    private Pane paneMenuLocacoesExpandido;

    @FXML
    private Pane paneMenuLocacoesFechado;

    @FXML
    private Pane paneMenuVeiculosExpandido;

    @FXML
    private Pane paneMenuVeiculosFechado;

    @FXML
    private AnchorPane rootPane;

    @FXML
    void adicionaCategoria(ActionEvent event) {

    }

    @FXML
    void adicionaCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/client/viewCreateClient.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            alertInterface("ERRO", "Não foi possível entrar na tela de alterar produto", AlertType.ERROR);
        }
    }

    @FXML
    void adicionaLocacao(ActionEvent event) {

    }

    @FXML
    void adicionaVeiculo(ActionEvent event) {

    }

    @FXML
    void alteraInformacoesCategoria(ActionEvent event) {

    }

    @FXML
    void alteraInformacoesLocacao(ActionEvent event) {

    }

    @FXML
    void alteraInformacoesVeiculo(ActionEvent event) {

    }

    @FXML
    void alterarInformacoesCliente(ActionEvent event) {

    }

    @FXML
    void fecharMenuCategoria(MouseEvent event) {
        paneMenuCategoriasExpandido.setVisible(false);
    }

    @FXML
    void fecharMenuClientes(MouseEvent event) {
        paneMenuClientesExpandido.setVisible(false);
    }

    @FXML
    void fecharMenuLocacoes(MouseEvent event) {
        paneMenuLocacoesExpandido.setVisible(false);
    }

    @FXML
    void fecharMenuVeiculos(MouseEvent event) {
        paneMenuVeiculosExpandido.setVisible(false);
    }

    @FXML
    void hoverBtnCategoria(MouseEvent event) {
        paneMenuCategoriasExpandido.setVisible(true);
    }

    @FXML
    void hoverBtnCliente(MouseEvent event) {
        paneMenuClientesExpandido.setVisible(true);
    }

    @FXML
    void hoverBtnLocacao(MouseEvent event) {
        paneMenuLocacoesExpandido.setVisible(true);
    }

    @FXML
    void hoverBtnVeiculo(MouseEvent event) {
        paneMenuVeiculosExpandido.setVisible(true);
    }

    @FXML
    void removeCategoria(ActionEvent event) {

    }

    @FXML
    void removeCliente(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/client/viewDeleteClient.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            alertInterface("ERRO", "Não foi possível entrar na tela de excluir um cliente", AlertType.ERROR);
        }
    }

    @FXML
    void removeLocacao(ActionEvent event) {

    }

    @FXML
    void removeVeiculo(ActionEvent event) {

    }

    @FXML
    void visualizaInformacoesCategoria(ActionEvent event) {

    }

    @FXML
    void visualizaInformacoesCliente(ActionEvent event) {

    }

    @FXML
    void visualizaInformacoesLocacao(ActionEvent event) {

    }

    @FXML
    void visualizaInformacoesVeiculo(ActionEvent event) {

    }

    void alertInterface(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
