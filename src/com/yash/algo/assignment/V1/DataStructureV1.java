package com.yash.algo.assignment.V1;

import com.yash.algo.assignment.ElementNotFoundException;

public interface DataStructureV1<T extends Comparable<T>> {
    public abstract void insert(T key);
    public abstract void delete(T key) throws ElementNotFoundException;
    public abstract void ascendingOrder();
}
