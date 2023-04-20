package com.yash.algo.assignment;

public class ElementNotFoundException extends Exception{
    private final int line;
    public ElementNotFoundException() {
        line = 0;
    }

    public ElementNotFoundException(int data) {
        line = data;
    }
    public String toString() {
        return "delete object in Line "+ line +" not found in the tree.";
    }
}
