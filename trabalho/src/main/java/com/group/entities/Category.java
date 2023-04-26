package com.group.entities;

public class Category {

    private String name;
    private long id;

    public Category(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return id;
    }
    
}
