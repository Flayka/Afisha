package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int showMovieLength = 10;
    private int chooseMovieLength;

    public MovieManager(int chooseMovieLength) {
        this.chooseMovieLength = chooseMovieLength;
    }

    public void setChooseMovieLength(int chooseMovieLength) {
        this.chooseMovieLength = chooseMovieLength;
    }

    public void add(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getAll() {
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
}
