package com.group.list;

import com.group.entities.Client;
import com.group.lde.LdeClient;
import com.group.lde.Node;

public class ListClient {

    private LdeClient ldeClient;

    public ListClient() {
        this.ldeClient = new LdeClient();
    }

    public ListClient(LdeClient ldeClient) {
        this.ldeClient = ldeClient;
    }

    public void addClientAtBeginning(Client client) {
        if(client == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeClient.insertAtBeginning(client);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addClientAtEnd(Client client) {
        if(client == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeClient.insertAtEnd(client);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean removeClient(String cpf) {
        if(cpf == null || cpf.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            return this.ldeClient.remove(cpf);
        } catch (Exception e) {
            throw e;
        }
    }

    public Node find(String cpf) {
        if(cpf == null || cpf.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            return this.ldeClient.find(cpf);
        } catch (Exception e) {
            throw e;
        }      
    }

    public boolean existe(String cpf) {
        if(cpf == null || cpf.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeClient.find(cpf);

        return node != null;
    }

    public Node findByCNH(String cnh) {
        if(cnh == null || cnh.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            return this.ldeClient.findByCNH(cnh);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean existeByCNH(String cnh) {
        if(cnh == null || cnh.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeClient.findByCNH(cnh);

        return node != null;
    }

    public int size() {
        return this.ldeClient.size();
    }

    public boolean isEmpty() {
        return this.ldeClient.isEmpty();
    }
   
    public String getListFromBeginning() {
       return this.ldeClient.getListFromBeginning();
    }

    public String getListFromEnd() {
        return this.ldeClient.getListFromEnd();
    }

    public void setName(Client client, String name) {
        if(client == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException("O nome informado é nulo");
        }

        client.setName(name);
    }

    public void setPhone(Client client, String phone) {
        if(client == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        if(phone == null || phone.trim().isEmpty()) {
            throw new NullPointerException("O telefone informado é nulo");
        }

        client.setPhone(phone);
    }

    public void setCnh(Client client, String cnh) {
        if(client == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        if(cnh == null || cnh.trim().isEmpty()) {
            throw new NullPointerException("A CNH informada é nula");
        }

        client.setCnh(cnh);
    }

}
