package com.example.demo.models;

public class Movie implements Comparable<Movie> {
    private String year;
    private String length;
    private String title;
    private String subject;
    private int popularity;
    private String awards;

    public Movie(String year, String length, String title, String subject, int popularity, String awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public Movie() {
    }

    public String getTitle(){
        return this.title;
    }

    public String hasAwards() {
        return awards;
    }

    public String getInfo(){
        return "Score: " + this.popularity + " / Title: " + this.title + " / Awards: " + this.awards;
    }

    public int getPopularity() { return this.popularity;}

    @Override
    public int compareTo(Movie compareMovie) {
        return Integer.compare(compareMovie.popularity, this.popularity);
    }
}
