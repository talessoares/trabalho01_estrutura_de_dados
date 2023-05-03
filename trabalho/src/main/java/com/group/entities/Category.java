package com.group.entities;

public class Category {

    private String name;
    private long id;
    private static long idCounter = 1017;

    public Category(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id:" + id + ";Nome:" + name;
    }
    
}
