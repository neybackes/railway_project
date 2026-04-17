package com.solvd.railway.functional;

@FunctionalInterface
public interface Validate<T> {
    boolean test(T value);
}