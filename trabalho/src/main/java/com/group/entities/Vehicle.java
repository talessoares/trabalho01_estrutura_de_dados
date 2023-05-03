package com.group.entities;

public class Vehicle {
    
    private String plate;
    private String model;
    private int year;
    private int horsePower;
    private int seats;
    private String brand;
    private Category category;

    public Vehicle(String plate, String model, int year, int horsePower, int seats, String brand, Category category) {
        this.plate = plate;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        this.seats = seats;
        this.brand = brand;
        this.category = category;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getHorsePower(){
        return horsePower;
    }

    public int getSeats(){
        return seats;
    }

    public String getBrand(){
        return brand;
    }

    public Category getCategory(){
        return category;
    }

    public void setPlate(String plate) {
        if(plate == null || plate.trim().isEmpty()) {
            throw new NullPointerException("Placa não pode ser nula!");
        }

        this.plate = plate;
    }

    public void setModel(String model) {
        if(model == null || model.trim().isEmpty()) {
            throw new NullPointerException("Modelo não pode ser nulo!");
        }

        this.model = model;
    }

    public void setYear(int year) {
        if(year < 0) {
            throw new NullPointerException("Ano não pode ser negativo!");
        }

        this.year = year;
    }

    public void setHorsePower(int horsePower) {
        if(horsePower < 0) {
            throw new NullPointerException("Potência não pode ser negativa!");
        }

        this.horsePower = horsePower;
    }

    public void setSeats(int seats) {
        if(seats < 0) {
            throw new NullPointerException("Quantidade de assentos não pode ser negativa!");
        }

        this.seats = seats;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()) {
            throw new NullPointerException("Marca não pode ser nula!");
        }

        this.brand = brand;
    }

    public void setCategory(Category category) {
        if(category == null) {
            throw new NullPointerException("Categoria não pode ser nula!");
        }

        this.category = category;
    }

    @Override
    public String toString() {
        return "Plate:" + plate + ";Model:" + model + ";Year:" + year + ";Horse Power:" + horsePower + ";Seats:" + seats + ";Brand:" + brand + ";Category:" + category.toString();
    }

}
