package com.classtune.movietune.model;

import java.util.List;

/**
 * Created by user- on 25-Nov-16.
 */

public class MovieDetail {

    private boolean adult;
    private String backdrop_path;
    private long budget;
    private List<Genres> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private List<ProductionCompanies> production_companies;
    private List<ProductionCountries> production_countries;
    private String release_date;
    private long revenue;
    private int runtime;
    private List<SpokenLanguages> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;

    public MovieDetail() {
    }

    public MovieDetail(boolean adult, String backdrop_path, long budget, List<Genres> genres, String homepage,
                       int id, String imdb_id, String original_language, String original_title, String overview,
                       double popularity, String poster_path, List<ProductionCompanies> production_companies,
                       List<ProductionCountries> production_countries, String release_date, long revenue,
                       int runtime, List<SpokenLanguages> spoken_languages,
                       String status, String tagline, String title, boolean video, double vote_average, int vote_count) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<ProductionCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public List<ProductionCountries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<ProductionCountries> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SpokenLanguages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", budget=" + budget +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + production_companies +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}


