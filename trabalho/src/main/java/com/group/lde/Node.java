package com.group.lde;

public class Node {
    
    private Object info;
    private Node next;
    private Node previous;

    public Node(Object info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    public Object getInfo() { 
        return this.info;
    }

    public Node getNext() { 
        return this.next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public Node getPrevious() { 
        return this.previous;
    }

    public void setPrevious(Node n) {
        this.previous = n;
    }

}
