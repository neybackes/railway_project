package com.solvd.railway.generics;

public class Holder<T> {

    private T item;

    public Holder(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
