package com.group;

import com.group.entities.Category;
import com.group.entities.Vehicle;
import com.group.list.ListCategory;
import com.group.list.ListClient;
import com.group.list.ListLocation;
import com.group.list.ListVehicle;
import com.group.utilities.ReadCSV;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Iniciando aplicação");

        final String viewInicial = "views/viewIndex.fxml";
        final String tituloApp = "Locadora ED";
        final boolean telaResizable = false;

        final String filePathCategory = "trabalho\\src\\main\\java\\com\\group\\csv\\Categorias.csv";
        final String filePathVehicle = "trabalho\\src\\main\\java\\com\\group\\csv\\Veiculos.csv";

        ReadCSV readCSV = new ReadCSV(filePathCategory);
        
        ListCategory listCategory = new ListCategory();
        ListVehicle listVehicle = new ListVehicle();
        ListClient listClient = new ListClient();
        ListLocation listLocation = new ListLocation();

        try {
            readCSV.read();
            String content = readCSV.getContent();
            String[] contentBreak = content.split("\n");

            for(int i = 1; i < contentBreak.length; i++) {

                String[] contentData = contentBreak[i].split(";");
                String id = contentData[0];
                String name = contentData[1];

                long idLong = 0;

                try {
                    idLong = Long.parseLong(id);
                } catch (Exception e) {
                    System.out.println("Erro ao passar id para long: " + e.getMessage());
                }
                
                Category category = new Category(name, idLong);
                
                try {
                    listCategory.addClientAtEnd(category);
                } catch (Exception e) {
                    System.out.println("Erro ao adicionar categoria: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        readCSV.setFilePath(filePathVehicle);

        try {
            readCSV.read();
            String content = readCSV.getContent();
            String[] contentBreak = content.split("\n");

            for(int i = 1; i < contentBreak.length; i++) {

                String[] contentData = contentBreak[i].split(";");
                String placa = contentData[0];
                String modelo = contentData[1];
                String marca = contentData[2];
                String ano = contentData[3];
                String potencia = contentData[4];
                String lugares = contentData[5];
                String categoria = contentData[6];

                int intAno = 0;
                int intPotencia = 0;
                int intLugares = 0;

                try {
                    intAno = Integer.parseInt(ano);
                } catch (Exception e) {
                    System.out.println("Erro ao passar ano para loteirong: " + e.getMessage());
              }

                try {
                    intPotencia = Integer.parseInt(potencia);
                } catch (Exception e) {
                    System.out.println("Erro ao passar potencia para Inteiro: " + e.getMessage());
                }

                try {
                    intLugares = Integer.parseInt(lugares);
                } catch (Exception e) {
                    System.out.println("Erro ao passar lugares para Inteiro: " + e.getMessage());
                }

                Category category = (Category) listCategory.find(Long.parseLong(categoria)).getInfo();

                Vehicle vehicle = new Vehicle(placa, modelo, intAno, intPotencia, intLugares, marca, category);  

                try {
                    listVehicle.addVehicleAtEnd(vehicle);
                } catch (Exception e) {
                    System.out.println("Erro ao adicionar categoria: " + e.getMessage());
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewInicial));
            Parent root = fxmlLoader.load();
            Scene tela = new Scene(root);

            primaryStage.setTitle(tituloApp);
            primaryStage.setScene(tela);
            primaryStage.setResizable(telaResizable);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
