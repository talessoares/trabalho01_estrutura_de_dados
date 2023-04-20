package com.teste.lde;

public class Lde implements ILde {

    private Noh begin;
    private Noh end;

    public Lde() {
        this.begin = null;
        this.end = null;
    }

    @Override
    public void insertAtBeginning(Object info) {
        Noh newNode = new Noh(info);

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
        Noh newNode = new Noh(info);

        if (end == null) {
            begin = newNode;
            end = newNode;
        } else {
            newNode.setPrevious(end);
            end.setNext(newNode);
            end = newNode;
        }
    }

    // REVER ESSE MÉTODO PARA OBSERVAR A COMPARAÇÃO DO OBJETO
    @Override
    public Noh find(Object info) {
        Noh node = begin;

        while (node != null && node.getInfo() != info) {
            node = node.getNext();
        }
        
        return null;
    }

    @Override
    public boolean remove(Object info) {
        Noh node = find(info);

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

        for (Noh i = begin; i != null; i = i.getNext()) {
            size++;
        }

        return size;
    }

    @Override
    public String getListFromBeginning() {
        String list = "";

        for (Noh i = begin; i != null; i = i.getNext()) {
            list += i.getInfo() + " ";
        }

        return list;
    }

    @Override
    public String getListFromEnd() {
        String list = "";

        for (Noh i = end; i != null; i = i.getPrevious()) {
            list += i.getInfo() + " ";
        }

        return list;
    }

    @Override
    public boolean isEmpty() {
        return begin == null || end == null;
    }

}
