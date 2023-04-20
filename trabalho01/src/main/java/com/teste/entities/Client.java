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
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Nome não pode ser nulo!");
        }

        this.name = name;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        if(cnh < 0) {
            throw new NullPointerException("CNH não pode ser negativa!");
        }

        this.cnh = cnh;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        if(phone < 0) {
            throw new NullPointerException("Telefone não pode ser negativo!");
        }

        this.phone = phone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf == null || cpf.trim().isEmpty()) {
            throw new NullPointerException("CPF não pode ser nulo!");
        }

        this.cpf = cpf;
    }
}
