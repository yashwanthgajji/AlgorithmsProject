package com.yash.algo.assignment.V2;

import com.yash.algo.assignment.ElementNotFoundException;

public interface DataStructureV2<T extends Comparable<T>> {
    public abstract void insert(T key);
    public abstract void delete(T key) throws ElementNotFoundException;
    public abstract int height();
}