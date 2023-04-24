package com.group.menu;

import java.util.Scanner;
import com.group.lde.ILde;
import com.group.lde.Lde;
import com.group.entities.Client;
import com.group.list.ListClient;
import com.group.menu.PrincipalMenu;

import com.group.entities.Vehicle;

public class VehicleMenu {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir veículo");
            System.out.println("2 - Excluir veículo");
            System.out.println("3 - Editar dados de um veículo");
            System.out.println("4 - Listar todos os veículos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    incluirVeiculo();
                    break;
                case 2:
                    excluirVeiculo();
                    break;
                case 3:
                    editarVeiculo();
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void incluirVeiculo() {

        Scanner scanner = new Scanner(System.in);
        String plate, model, brand, category;
        int year, horsePower, seats;
        
        System.out.println("Digite a placa do veículo:");
        plate = scanner.nextLine();
        
        System.out.println("Digite o modelo do veículo:");
        model = scanner.nextLine();
        
        System.out.println("Digite a marca do veículo:");
        brand = scanner.nextLine();
        
        System.out.println("Digite o ano do veículo:");
        year = scanner.nextInt();
        
        System.out.println("Digite a potência do veículo:");
        horsePower = scanner.nextInt();
        
        System.out.println("Digite o número de lugares do veículo:");
        seats = scanner.nextInt();

        System.out.println("Escolha a categoria do veículo:");
        category = scanner.nextLine();
        
        Vehicle vehicle = new Vehicle(plate, model, year, horsePower, seats, brand, category);
        vehicles.add(vehicle);
        
        System.out.println("Veículo adicionado com sucesso!");
    }

    private static void excluirVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a placa do veículo que deseja excluir: ");
        String plate = scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().equals(plate)) {
                if (vehicle.isRented()) {
                    System.out.println("Não é possível excluir o veículo pois ele está atrelado a uma locação.");
                    return;
                }
                vehicle.remove(vehicle);
                System.out.println("Veículo removido com sucesso!");
                return;
            }
        }

        System.out.println("Veículo não encontrado.");
    }

    private static void editarVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a placa do veículo que deseja editar: ");
        String plate = scanner.nextLine();

        Vehicle vehicle = findVehicleByPlate(plate);

        if (vehicle == null) {
            System.out.println("Veículo não encontrado.");
        } else {
            System.out.println("Selecione o campo a ser editado:");
            System.out.println("1 - Placa");
            System.out.println("2 - Modelo");
            System.out.println("3 - Marca");
            System.out.println("4 - Ano");
            System.out.println("5 - Potência");
            System.out.println("6 - Número de lugares");
            System.out.println("7 - Categoria");
            System.out.print("Escolha uma opção: ");
            int opcaoedit = scanner.nextInt();
            switch(opcaoedit) {
                case 1:
                    System.out.print("Digite a nova placa: ");
                    String newPlate = scanner.nextLine();
                    vehicle.setPlate(newPlate);
                    break;
                case 2:
                    System.out.print("Digite o novo modelo: ");
                    String newModel = scanner.nextLine();
                    vehicle.setModel(newModel);
                    break;
                case 3:
                    System.out.print("Digite a nova marca: ");
                    String newBrand = scanner.nextLine();
                    vehicle.setBrands(newBrand);
                    break;
                case 4:
                    System.out.print("Digite o novo ano: ");
                    int newYear = scanner.nextInt();
                    vehicle.setYear(newYear);
                    break;
                case 5:
                    System.out.print("Digite a nova potência: ");
                    int newHorsePower = scanner.nextInt();
                    vehicle.setHorsePower(newHorsePower);
                    break;
                case 6:
                    System.out.print("Digite o novo número de lugares: ");
                    int newSeats = scanner.nextInt();
                    vehicle.setSeats(newSeats);
                    break;
                case 7:
                    System.out.print("Digite a nova categoria: ");
                    String newCategory = scanner.nextLine();
                    vehicle.setCategory(newCategory);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");

            }
        System.out.println("Veículo não encontrado.");
    }
}     
}

