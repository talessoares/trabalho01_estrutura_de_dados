package com.teste.menu;

import java.util.Scanner;
import com.teste.lde.ILde;
import com.teste.lde.Lde;
import com.teste.entities.Client;
import com.teste.list.listClient;
import com.teste.menu.principalMenu;

public class clientMenu {

    private Lde clientList;

    public clientMenu() {
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
        principalMenu.clientList.add(client);
        
    }

    public void removeClient() {

    }

    public void editClient() {

    }

    public void listClient() {

    }
}
