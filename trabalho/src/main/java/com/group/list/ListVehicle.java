package com.group.list;

import com.group.entities.Vehicle;
import com.group.lde.LdeVehicle;
import com.group.lde.Node;
import com.group.entities.Category;

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

    public boolean removeVehicle(Vehicle vehicle) {
        if(vehicle == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeVehicle.remove(vehicle);
    }

    public Node find(String plate) {
        if(plate == null || plate.trim().isEmpty()) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeVehicle.find(plate);        
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

    public void setPlate(Vehicle vehicle, String plate){

        if(vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }
        
        if(plate == null || plate.trim().isEmpty()) {
            throw new NullPointerException("Placa não pode ser nula!");
        }
        
        vehicle.setPlate(plate);
    }
    
    public void setModel(Vehicle vehicle, String model){

        if(vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        if(model == null || model.trim().isEmpty()) {
            throw new NullPointerException("Modelo não pode ser nulo!");
        }

        vehicle.setModel(model);
    }

    public void setBrand(Vehicle vehicle, String brand){

        if(vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        if(brand == null || brand.trim().isEmpty()) {
            throw new NullPointerException("Marca não pode ser nula!");
        } 

        vehicle.setBrand(brand);
    }
    
   

    public void setYear(Vehicle vehicle, int year){

        if (vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        if (year == 0) {
            throw new NullPointerException("Ano não pode ser nulo!");
        }

        vehicle.setYear(year);
    }

    public void setSeats(Vehicle vehicle, int seats){

        if (vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        if (seats == 0) {
            throw new NullPointerException("Quantidade de assentos não pode ser nula!");
        }

        vehicle.setSeats(seats);
    }

    public void setHorsePower(Vehicle vehicle, int horsePower){

        if (vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        if (horsePower == 0) {
            throw new NullPointerException("Cavalos não pode ser nulo!");
        }

        vehicle.setHorsePower(horsePower);
    }

    public void setCategory(Vehicle vehicle, Category category){

        if (vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        if (category == null ) {
            throw new NullPointerException("Categoria não pode ser nula!");
        }

        vehicle.setCategory(category);
    }    

        



}