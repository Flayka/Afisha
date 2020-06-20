package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] items = new Movie[0];

    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Movie findById(int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Movie[] removeAll() {
        return items = new Movie[0];
    }
}
