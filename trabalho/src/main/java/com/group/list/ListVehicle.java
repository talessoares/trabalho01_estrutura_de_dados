package com.group.list;

import com.group.entities.Vehicle;
import com.group.lde.LdeVehicle;
import com.group.lde.Node;

public class ListVehicle {

    private LdeVehicle ldeVehicle;

    public ListVehicle() {
        this.ldeVehicle = new LdeVehicle();
    }

    public ListVehicle(LdeVehicle ldeVehicle) {
        this.ldeVehicle = ldeVehicle;
    }

    public void addVehicleAtBeginning(Vehicle vehicle) {
        if(vehicle == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeVehicle.insertAtBeginning(vehicle);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addVehicleAtEnd(Vehicle vehicle) {
        if(vehicle == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeVehicle.insertAtEnd(vehicle);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean removeVehicle(String vehicle) {
        if(vehicle == null || vehicle.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é vazio");
        }

        return this.ldeVehicle.remove(vehicle);
    }

    public Node find(String plate) {
        if(plate == null || plate.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeVehicle.find(plate);        
    }

    public boolean existe(String plate) {
        if(plate == null || plate.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeVehicle.find(plate);
        
        return node != null;
    }

    public Node findByCategory(long id) {
        if(id <= 0) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeVehicle.findByCategory(id);        
    }

    public boolean existeByCategory(long id) {
        if(id <= 0) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeVehicle.findByCategory(id);
        
        return node != null;
    }

    public int size() {
        return this.ldeVehicle.size();
    }

    public boolean isEmpty() {
        return this.ldeVehicle.isEmpty();
    }
   
    public String getListFromBeginning() {
       return this.ldeVehicle.getListFromBeginning();
    }

    public String getListFromEnd() {
        return this.ldeVehicle.getListFromEnd();
    }
 
}