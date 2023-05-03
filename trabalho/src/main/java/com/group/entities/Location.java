package com.group.entities;

import java.util.Calendar;

public class Location {

    private Client client;
    private Vehicle vehicle;
    private Calendar locationDate;
    private Calendar devolutionDate;
    private double value;

    public Location(Client client, Vehicle vehicle, Calendar locationDate, Calendar devolutionDate, double value) {
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

    public Calendar getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(Calendar locationDate) {
        if (locationDate == null) {
            throw new NullPointerException("Data de locação não pode ser nula!");
        }

        this.locationDate = locationDate;
    }

    public Calendar getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Calendar devolutionDate) {
        if (devolutionDate == null) {
            throw new NullPointerException("Data de devolução não pode ser nula!");
        }

        this.devolutionDate = devolutionDate;
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

    @Override
    public String toString() {
        return "Cnh:" + client.getCnh() + ";Placa:" + vehicle.getPlate() + ";Data de locação:" + locationDate + ";Data de devolução:" + devolutionDate + ";Valor:" + value;
    }
    

}
