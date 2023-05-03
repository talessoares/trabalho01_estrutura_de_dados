package com.group.lde;

import com.group.entities.Vehicle;

public class LdeVehicle implements ILde {

    private Node begin;
    private Node end;

    public LdeVehicle() {
        this.begin = null;
        this.end = null;
    }

    @Override
    public void insertAtBeginning(Object info) {

        if (!(info instanceof Vehicle)) {
            throw new IllegalArgumentException("O objeto informado não é um veículo");
        }

        Vehicle vehicle = (Vehicle) info;
        Node newNode = new Node(vehicle);

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

        if (!(info instanceof Vehicle)) {
            throw new IllegalArgumentException("O objeto informado não é um veículo");
        }

        Vehicle vehicle = (Vehicle) info;
        Node newNode = new Node(vehicle);

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
        return begin == null || end == null;
    }

    @Override
    public boolean remove(Object info) {

        if (!(info instanceof String)) {
            throw new IllegalArgumentException("O objeto informado não é uma string");
        }

        String placa = (String) info;
        Node node = find(placa);

        if (node == null) {
            return false;
        }

        if (node == begin) {
            begin = node.getNext();

            if (begin != null) {
                begin.setPrevious(null);
            } else {
                end = null;
            }

        } else if (node.getNext() == null) {
            node.getPrevious().setNext(null);
            end = node.getPrevious();
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
        return true;
    }

    @Override
    public int size() {
        int size = 0;

        for (Node i = begin; i != null; i = i.getNext()) {
            size++;
        }

        return size;
    }

    @Override
    public String getListFromBeginning() {
        String list = "";

        for (Node i = begin; i != null; i = i.getNext()) {
            list += i.getInfo().toString() + "\n";
        }

        return list;
    }

    @Override
    public String getListFromEnd() {
        String list = "";

        for (Node i = end; i != null; i = i.getPrevious()) {
            list += i.getInfo() + "\n";
        }

        return list;
    }

    @Override
    public Node find(Object info) {
        if (!(info instanceof String)) {
            throw new IllegalArgumentException("O objeto informado não é uma string");
        }

        String plate = (String) info;
        Node node = begin;

        while (node != null && (!((Vehicle) node.getInfo()).getPlate().equals(plate))) {
            node = node.getNext();
        }

        return node;
    }

    public Node findByCategory(Object info) {
        if (!(info instanceof Long)) {
            throw new IllegalArgumentException("O objeto informado não é uma locação");
        }

        long id = (Long) info;

        Node node = begin;

        while (node != null && ((Vehicle) node.getInfo()).getCategory().getId() != id) {
            node = node.getNext();
        }

        return node;
    }

}
