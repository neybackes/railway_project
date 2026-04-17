package com.solvd.railway.functional;

@FunctionalInterface
public interface Show<T> {
    void execute(T input);
}