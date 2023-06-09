package com.group.list;

import com.group.entities.Location;
import com.group.lde.LdeLocation;
import com.group.lde.Node;

public class ListLocation { 

    private LdeLocation ldeLocation;

    public ListLocation() {
        this.ldeLocation = new LdeLocation();
    }

    public ListLocation(LdeLocation ldeLocation) {
        this.ldeLocation = ldeLocation;
    }

    public void addLocationAtBeginning(Location location) {
        if(location == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeLocation.insertAtBeginning(location);
        } catch (Exception e) {
            throw e;
        }
     }

     public void addLocationAtEnd(Location location) {
        if(location == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeLocation.insertAtEnd(location);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean removeLocation(String placa) {
        if(placa == null || placa.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            return this.ldeLocation.remove(placa);
        } catch (Exception e) {
            throw e;
        }
    }

    public int size() {
        return this.ldeLocation.size();
    }

    public boolean isEmpty() {
        return this.ldeLocation.isEmpty();
    }
   
    public String getListFromBeginning() {
       return this.ldeLocation.getListFromBeginning();
    }

    public String getListFromEnd() {
        return this.ldeLocation.getListFromEnd();
    }

    public Node find(String placa) {
        if(placa == null || placa.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeLocation.find(placa);        
    }

    public boolean existe(String placa) {
        if(placa == null || placa.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeLocation.find(placa);
        
        return node != null;
    }

    public Node findByCnh(String cnh) {
        if(cnh == null || cnh.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeLocation.findByCnh(cnh);        
    }

    public boolean existeByCNH(String cnh) {
        if(cnh == null || cnh.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeLocation.findByCnh(cnh);
        
        return node != null;
    }

    
}