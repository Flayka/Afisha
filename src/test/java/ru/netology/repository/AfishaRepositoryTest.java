package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Movie first = new Movie(1, 1, "Jaws1", "horror", true);
    private Movie second = new Movie(2, 2, "Jaws2", "horror", true);
    private  Movie third = new Movie(3, 3, "Jaws3", "horror", false);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 2;
        repository.findById(idToFind);
        Movie actual = repository.findById(idToFind);
        Movie expected = second;

        assertEquals(expected, actual);
    }

    @Test
    void shouldNoFindById() {
        int idToFind = 5;
        repository.findById(idToFind);
        Movie actual = repository.findById(idToFind);
        Movie expected = null;

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.removeAll();
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, actual);
    }
}
