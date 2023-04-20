package com.teste.lde;

public class Lde implements ILde {

    private Noh inicio;
    private Noh fim;

    public Lde() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public void insereInicio(Object info) {
        Noh novo = new Noh(info);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    @Override
    public void insereFim(Object info) {
        Noh novo = new Noh(info);

        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
        }
    }

    // REVER ESSE MÉTODO PARA OBSERVAR A COMPARAÇÃO DO OBJETO
    @Override
    public Noh consultarInfo(Object info) {
        Noh p = inicio;

        while (p != null && p.getInfo() != info) {
            p = p.getProximo();
        }
        
        return null;
    }

    @Override
    public boolean remove(Object info) {
        Noh p = consultarInfo(info);

        if (p == null) {
            return false;
        }

        if (p == inicio) {
            inicio = p.getProximo();

            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }

        } else if (p.getProximo() == null) {
            p.getAnterior().setProximo(null);
            fim = p.getAnterior();
        } else {
            p.getAnterior().setProximo(p.getProximo());
            p.getProximo().setAnterior(p.getAnterior());
        }
        return true;
    }

    @Override
    public int tamanho() {
        int tamanho = 0;

        for (Noh i = inicio; i != null; i = i.getProximo()) {
            tamanho++;
        }

        return tamanho;
    }

    @Override
    public String getListaInicio() {
        String lista = "";

        for (Noh i = inicio; i != null; i = i.getProximo()) {
            lista += i.getInfo() + " ";
        }

        return lista;
    }

    @Override
    public String getListaFim() {
        String lista = "";

        for (Noh i = fim; i != null; i = i.getAnterior()) {
            lista += i.getInfo() + " ";
        }

        return lista;
    }

    @Override
    public boolean estahVazia() {
        return inicio == null || fim == null;
    }

}
