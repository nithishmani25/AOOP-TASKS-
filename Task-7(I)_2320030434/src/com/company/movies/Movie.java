package com.company.movies;

public class Movie implements Comparable<Movie> {
    private String name;
    private double rating;
    private int year;

    // Constructor
    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    // compareTo method to sort by year of release
    @Override
    public int compareTo(Movie otherMovie) {
        return Integer.compare(this.year, otherMovie.year); // Compare years
    }

    @Override
    public String toString() {
        return "Movie{name='" + name + "', rating=" + rating + ", year=" + year + "}";
    }
}
