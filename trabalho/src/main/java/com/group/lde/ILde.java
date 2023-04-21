package com.group.lde;

public interface ILde {

    public void insertAtBeginning(Object info);

    public void insertAtEnd(Object info);

    public boolean isEmpty();

    public boolean remove(Object info);

    public int size();

    // Retorna uma String que representa a lista a partir do inicio até o fim
    public String getListFromBeginning();

    // Retorna uma String que representa a lista a partir do fim até o inicio
    public String getListFromEnd();

    // Retorna o Noh que contém o objeto info
    public Noh find(Object info);
    
}