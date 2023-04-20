package com.teste.lde;

public interface ILde {

    public void insereInicio(Object info);
    public void insereFim(Object info);
    public boolean estahVazia();
    public boolean remove(Object info);
    public int tamanho();

    // Retorna uma String que representa a lista a partir do inicio até o fim
    public String getListaInicio();

    // Retorna uma String que representa a lista a partir do fim até o inicio
    public String getListaFim();

    // Retorna o Noh que contém o objeto info
    public Noh consultarInfo(Object info);
    
}