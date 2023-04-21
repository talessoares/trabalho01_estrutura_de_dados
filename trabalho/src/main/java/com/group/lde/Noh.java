package com.group.lde;

public class Noh {
    
    private Object info;
    private Noh next;
    private Noh previous;

    public Noh(Object info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    public Object getInfo() { 
        return this.info;
    }

    public Noh getNext() { 
        return this.next;
    }

    public void setNext(Noh n) {
        this.next = n;
    }

    public Noh getPrevious() { 
        return this.previous;
    }

    public void setPrevious(Noh n) {
        this.previous = n;
    }

}
