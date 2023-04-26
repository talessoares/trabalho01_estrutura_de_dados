package com.group.list;

import com.group.lde.Noh;
import com.group.entities.Client;
import com.group.lde.ILde;


public class ListClient implements ILde {

    private Noh begin;
    private Noh end;

    public ListClient() {
        this.begin = null;
        this.end = null;
    }

    public void editClient(Object info) throws IllegalArgumentException  {
        if (!(info instanceof Client)) { 
            throw new IllegalArgumentException("O objeto informado não é um cliente");
        }

    

    }

    public void listClients() {

    }

    @Override
    public void insertAtBeginning(Object info) throws IllegalArgumentException {
        if (!(info instanceof Client)) { 
            throw new IllegalArgumentException("O objeto informado não é um cliente");
        } 

        Client client = (Client) info;
        Noh newNode = new Noh(client);
        if (begin == null) {
            begin = newNode;
            end = newNode;
        } else {
            newNode.setNext(begin);
            begin.setNext(newNode);
            begin = newNode;
        }
    }
    

    @Override
    public void insertAtEnd(Object info) {
        if (!(info instanceof Client)) { 
            throw new IllegalArgumentException("O objeto informado não é um cliente");
        }

        Client client = (Client) info;
        Noh newNode = new Noh(client);
        if (end == null) {
            begin = newNode;
            end = newNode;
        } else {
            newNode.setPrevious(end);
            end.setNext(newNode);
            end = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        throw new NullPointerException("Método não implementado");
    }

    @Override
    public boolean remove(Object info) {
        throw new NullPointerException("Método não implementado");
    }

    @Override
    public int size() {
        throw new NullPointerException("Método não implementado");
    }

    @Override
    public String getListFromBeginning() {
        throw new NullPointerException("Método não implementado");
    }

    @Override
    public String getListFromEnd() {
        throw new NullPointerException("Método não implementado");
    }

    @Override
    public Noh find(Object info) {
        Noh node = begin;

        while (node != null && node.getInfo() != info) {
            node = node.getNext();
        }
        
        return node;
    }
}
