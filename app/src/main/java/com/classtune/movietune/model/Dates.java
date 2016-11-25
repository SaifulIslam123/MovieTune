package com.classtune.movietune.model;

/**
 * Created by user- on 25-Nov-16.
 */

public class Dates {

    private String maximum;
    private  String minimum;

    public Dates() {
    }

    public Dates(String maximum, String minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "maximum='" + maximum + '\'' +
                ", minimum='" + minimum + '\'' +
                '}';
    }
}
