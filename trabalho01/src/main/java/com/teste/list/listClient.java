package com.teste.list;

import com.teste.lde.Noh;

import java.security.InvalidAlgorithmParameterException;

import com.teste.entities.Client;
import com.teste.lde.ILde;


public class listClient implements ILde{

    private Noh begin;
    private Noh end;

    public listClient() {
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
    }

    @Override
    public boolean remove(Object info) {
    }

    @Override
    public int size() {
    }

    @Override
    public String getListFromBeginning() {
    }

    @Override
    public String getListFromEnd() {
    }

    @Override
    public Noh find(Object info) {
    }
}
