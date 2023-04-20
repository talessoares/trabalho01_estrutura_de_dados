package com.teste.lde;

public class Noh {
    
    private Object info;
    private Noh proximo;
    private Noh anterior;

    public Noh(Object info) {
        this.info = info;
        this.proximo = null;
        this.anterior = null;
    }

    public Object getInfo() { 
        return this.info;
    }

    public Noh getProximo() { 
        return this.proximo;
    }

    public void setProximo(Noh n) {
        this.proximo = n;
    }

    public Noh getAnterior() { 
        return this.anterior;
    }

    public void setAnterior(Noh n) {
        this.anterior = n;
    }

}
