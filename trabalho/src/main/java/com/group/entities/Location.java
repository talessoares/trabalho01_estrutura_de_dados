package com.group.entities;

import java.util.Date;

public class Location {

    private Client client;
    private Vehicle vehicle;
    private Date locationDate;
    private Date devolutionDate;
    private long id;
    private double value;
    private static long idCounter = 1000;

    public Location(long id, Client client, Vehicle vehicle, Date locationDate, Date devolutionDate, double value) {
        this.id = idCounter++;
        this.client = client;
        this.vehicle = vehicle;
        this.locationDate = locationDate;
        this.devolutionDate = devolutionDate;
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client == null) {
            throw new NullPointerException("Cliente não pode ser nulo!");
        }

        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Veículo não pode ser nulo!");
        }

        this.vehicle = vehicle;
    }

    public Date getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(Date locationDate) {
        if (locationDate == null) {
            throw new NullPointerException("Data de locação não pode ser nula!");
        }

        this.locationDate = locationDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        if (devolutionDate == null) {
            throw new NullPointerException("Data de devolução não pode ser nula!");
        }

        this.devolutionDate = devolutionDate;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo!");
        }

        this.value = value;
    }
    

}
