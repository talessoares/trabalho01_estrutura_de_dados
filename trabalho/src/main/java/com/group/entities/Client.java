package com.group.entities;

public class Client {

    private String name;
    private String cnh;
    private String phone;
    private String cpf;

    public Client(String name, String cnh, String phone, String cpf) {
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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        if(cnh == null || cnh.trim().isEmpty()) {
            throw new NullPointerException("CNH não pode ser negativa!");
        }

        this.cnh = cnh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone == null || phone.trim().isEmpty()) {
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

    @Override
    public String toString() {
        return "Name: " + this.name + "; CNH: " + this.cnh + "; Phone: " + this.phone + "; CPF: " + this.cpf + ";";
    }

}
