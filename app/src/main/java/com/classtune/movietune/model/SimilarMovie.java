package com.classtune.movietune.model;

import java.util.List;

/**
 * Created by user- on 25-Nov-16.
 */

public class SimilarMovie {


    private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;



    public SimilarMovie() {
    }

    public SimilarMovie(int page, List<Movie> results, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
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
}
