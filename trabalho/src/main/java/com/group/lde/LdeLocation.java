package com.group.lde;

import com.group.entities.Location;

public class LdeLocation implements ILde {

    private Node begin;
    private Node end;

    public LdeLocation() {
        begin = null;
        end = null;
    }

    @Override
    public void insertAtBeginning(Object info) {
        if (!(info instanceof Location)) { 
            throw new IllegalArgumentException("O objeto informado não é uma locação");
        }

        Location location = (Location) info;
        Node newNode = new Node(location);

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
        if(!(info instanceof Location)) {
            throw new IllegalArgumentException("O objeto informado não é uma locação");
        } 

        Location location = (Location) info;
        Node newNode = new Node(location);

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
        if (!(info instanceof Location)) { 
            throw new IllegalArgumentException("O objeto informado não é uma locação");
        }

        Location location = (Location) info;
        Node node = find(location);

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
            list += i.getInfo() + "\n";
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
        if (!(info instanceof Location)) { 
            throw new IllegalArgumentException("O objeto informado não é uma locação");
        }
        
        Node node = begin;

        while (node != null && node.getInfo() != info) {
            node = node.getNext();
        }
        
        return null;
    }
    
    
}
