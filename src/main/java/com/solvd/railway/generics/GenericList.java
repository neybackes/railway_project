package com.solvd.railway.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public boolean remove(T item) {
        return items.remove(item);
    }


}
