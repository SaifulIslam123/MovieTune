package com.classtune.movietune.model;

/**
 * Created by user- on 25-Nov-16.
 */

public class ProductionCountries {

    private String iso_3166_1;
    private  String name;

    public ProductionCountries() {
    }

    public ProductionCountries(String iso_3166_1, String name) {
        this.iso_3166_1 = iso_3166_1;
        this.name = name;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductionCountries{" +
                "iso_3166_1='" + iso_3166_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
