package com.yash.algo.assignment;

public abstract class DataStructureV1<T extends Comparable<T>> {
    public abstract void insert(T key);
    public abstract void delete(T key) throws ElementNotFoundException;
}
