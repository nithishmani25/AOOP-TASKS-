package com.company.movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of Movie objects
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", 9.3, 1994));
        movies.add(new Movie("The Godfather", 9.2, 1972));
        movies.add(new Movie("The Dark Knight", 9.0, 2008));
        movies.add(new Movie("Pulp Fiction", 8.9, 1994));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", 8.9, 2003));

        // Sort the movies by their year of release using the compareTo method
        Collections.sort(movies);

        // Print the sorted list of movies
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
