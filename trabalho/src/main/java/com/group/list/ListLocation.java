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

    // public void setClient(Location location, Client client) {
    //     if(location == null) {
    //         throw new NullPointerException("O objeto informado é nulo");
    //     }

    //     if (client == null || client.getCpf().trim().isEmpty()) {
    //         throw new NullPointerException("O cliente informado é nulo");
    //     }

    //     vehicle.setClient(client);
    // }

    // public void setVehicle(Location location, Vehicle vehicle) {
    //     if(location == null) {
    //         throw new NullPointerException("O objeto informado é nulo");
    //     }

    //     if (vehicle == null || vehicle.getPlate().trim().isEmpty()) {
    //         throw new NullPointerException("O veículo informado é nulo");
    //     }

    //     vehicle.setVehicle(vehicle);
    // }

    // public void setLocationDate(Location location, Date locationDate){
    //     if(location == null) {
    //         throw new NullPointerException("O objeto informado é nulo");
    //     }

    //     if (locationDate == null || locationDate.trim().isEmpty()) {
    //         throw new NullPointerException("A data de locação não pode ser nula");
    //     }

    //     vehicle.setLocationDate(locationDate);
    // }

    // public void serDevolutionDate(Location location, Date devolutionDate){
    //     if(location == null) {
    //         throw new NullPointerException("O objeto informado é nulo");
    //     }

    //     if (devolutionDate == null || devolutionDate.trim().isEmpty()) {
    //         throw new NullPointerException("A data de devolução não pode ser nula");
    //     }

    //     vehicle.setDevolutionDate(devolutionDate);
    // }
}