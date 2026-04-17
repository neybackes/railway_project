package com.solvd.railway.functional;

@FunctionalInterface
public interface Mapper<T, R> {
    R map(T input);
}