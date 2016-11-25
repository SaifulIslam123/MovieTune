package com.classtune.movietune.model;

import java.util.List;

/**
 * Created by user- on 25-Nov-16.
 */

public class MoviePage {

    private int page;
    private List<Movie> results;
    private Dates dates;
    private int total_pages;
    private int total_results;


    public MoviePage() {
    }

    public MoviePage(int page, List<Movie> results, Dates dates, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.dates = dates;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getresults() {
        return results;
    }

    public void setresults(List<Movie> results) {
        this.results = results;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "MoviePage{" +
                "page=" + page +
                ", results=" + results +
                ", dates=" + dates +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
