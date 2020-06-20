package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {

    private AfishaRepository repository;
    private int showMovieLength = 10;
    private int chooseMovieLength;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int chooseMovieLength) {
        this.repository = repository;
        this.chooseMovieLength = chooseMovieLength;
    }

    public void setChooseMovieLength(int chooseMovieLength) {
        this.chooseMovieLength = chooseMovieLength;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] findAll() {
        Movie[] items = repository.findAll();

        int show = items.length;
        if (chooseMovieLength <= 0) {
            if (showMovieLength < show) {
                show = showMovieLength;
            }
        } else {
            if (chooseMovieLength < show) {
                show = chooseMovieLength;
            }
        }

        Movie[] result = new Movie[show];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}
