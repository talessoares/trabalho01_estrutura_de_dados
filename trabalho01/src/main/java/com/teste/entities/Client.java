package com.teste.entities;

public class Client {

    private String name;
    private int cnh;
    private int phone;
    private String cpf;

    public Client(String name, int cnh, int phone, String cpf) {
        this.name = name;
        this.cnh = cnh;
        this.phone = phone;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
