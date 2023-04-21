package com.group.menu;

import java.util.Scanner;
import com.group.lde.ILde;
import com.group.lde.Lde;
import com.group.entities.Client;
import com.group.list.ListClient;
import com.group.menu.PrincipalMenu;

public class ClientMenu {

    private ListClient clientList;

    public ClientMenu(ListClient clientList) {
        this.clientList = clientList;
    }

    public void addClient() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String name = input.nextLine();

        System.out.println("Digite o CPF do cliente: ");
        String cpf = input.nextLine();

        System.out.println("Digite o CNH do cliente: ");
        int cnh = input.nextInt();

        System.out.println("Digite o telefone do cliente: ");
        int phone = input.nextInt();

        Client client = new Client(name, cnh, phone, cpf);

        // TEM QUE FAZER O TRATAMENTO DE EXCEÇÃO, TEM QUE OLHAR O MÉTODO QUE TÁ
        // EXECUTANDO DO OBJETO
        // ASSIM COMO OS INPUTS, PARA VER SE É DO TIPO QUE É ESPERADO

        clientList.insertAtBeginning(client);

        input.close();

    }

    public void removeClient() {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF do cliente: ");
        String cpf = input.nextLine();

        try {
            clientList.remove(cpf); // aqui
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
            throw new NullPointerException("Não foi encontrado o cliente para remover");
        }
    }

    public void editClient(Object info) {
        
        // a gente tem que pedir o cpf do cliente e remover ele lá em cima, sem parâmetro de info

        // pera ai
        // buguei

    }

    public void listClient() {

    }
}
