package com.twu.biblioteca;
import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    private Movie movie1Test;

    @Test
    public void defaultOfZeroIfRatingNotSpecifiedWhenInstantiatingAMovie() {
        movie1Test = new Movie("my life movie", 1991, "me");
        assertEquals(movie1Test.getRating(), "unrated");
    }

}

