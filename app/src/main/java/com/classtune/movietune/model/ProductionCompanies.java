package com.classtune.movietune.model;

/**
 * Created by user- on 25-Nov-16.
 */

public class ProductionCompanies {

    private String name;
    private  int id;

    public ProductionCompanies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductionCompanies{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
