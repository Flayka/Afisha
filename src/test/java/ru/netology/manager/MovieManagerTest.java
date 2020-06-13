package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    MovieManager manager = new MovieManager(10);
    Movie first = new Movie(1, 1, "Jaws1", "horror", true);
    Movie second = new Movie(2, 2, "Jaws2", "horror", true);
    Movie third = new Movie(3, 3, "Jaws3", "horror", false);
    Movie fourth = new Movie(4, 4, "Jaws4", "horror", true);
    Movie fifth = new Movie(5, 5, "Jaws5", "horror", true);
    Movie sixth = new Movie(6, 6, "Jaws6", "horror", false);
    Movie seventh = new Movie(7, 7, "Jaws7", "horror", true);
    Movie eighth = new Movie(8, 8, "Jaws8", "horror", true);
    Movie ninth = new Movie(9, 9, "Jaws9", "horror", false);
    Movie tenth = new Movie(10, 10, "Jaws10", "horror", true);
    Movie eleventh = new Movie(11, 11, "SnowWhite", "animation", false);
    Movie twelfth = new Movie(11, 11, "SnowWhite2", "animation", true);

    @Test
    public void shouldLowerShowMovieLength() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMovieLength() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldHigherShowMovieLength() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldHigherChooseMovieLength() {
        MovieManager manager = new MovieManager(6);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldChooseMovieLengthZero() {
        MovieManager manager = new MovieManager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldChooseMovieLengthZero2() {
        MovieManager manager = new MovieManager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }
}
