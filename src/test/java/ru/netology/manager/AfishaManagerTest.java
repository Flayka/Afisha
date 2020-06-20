package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager = new AfishaManager(repository);
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

        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowMovieLength() {

        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldHigherShowMovieLength() {

        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldHigherChooseMovieLength() {
        AfishaManager manager = new AfishaManager(repository, 6);

        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldChooseMovieLengthZero() {
        AfishaManager manager = new AfishaManager(repository, 0);

        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldChooseMovieLengthZeroshowMovieLengthBelow10() {
        AfishaManager manager = new AfishaManager(repository, 0);

        Movie[] returned = new Movie[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldChooseMovieLengthLikeLength() {
        AfishaManager manager = new AfishaManager(repository, 1);

        Movie[] returned = new Movie[]{first};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveIfExists() {

        int idToRemove = 1;
        Movie[] returned = new Movie[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{third, second};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {

        int idToRemove = 4;
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{third, second, first};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }
}
