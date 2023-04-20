package com.teste.entities;

public class Vehicle {
    
    private String plate;
    private String model;
    private int year;
    private int horsePower;
    private int seats;
    private String brand;
    private String category;

    public Vehicle (String plate, String model, int year, int horsePower, int seats, String brand, String category){
        this.plate = plate;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        this.seats = seats;
        this.brand = brand;
        this.category = category;
    }

    public String getPlate(){
        return plate;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
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

    public String getCategory(){
        return category;
    }

    public void setPlate(String plate){
        this.plate = plate;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public void setBrands(String brand){
        this.brand = brand;
    }

    public void setCategory(String category){
        this.category = category;
    }

    

}
