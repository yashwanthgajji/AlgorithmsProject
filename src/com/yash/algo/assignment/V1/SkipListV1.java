package com.yash.algo.assignment.V1;

import com.yash.algo.assignment.ElementNotFoundException;
import com.yash.algo.assignment.V1.DataStructureV1;

import java.util.ArrayList;
import java.util.Random;

public class SkipListV1<T extends Comparable<T>> implements DataStructureV1<T> {
    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> next;
        Node<T> lower;
        Node() {
            next = null;
            lower = null;
        }
        Node(T key) {
            data = key;
            next = null;
            lower = null;
        }
    }

    static class Level<T extends Comparable<T>> {
        int level;
        Node<T> start;
        Node<T> end;
        Level(int level) {
            this.level = level;
            start = new Node<>();
            end = new Node<>();
            start.next = end;
        }
    }

    private final int numOfLevels;
    private Level<T>[] levels;

    public SkipListV1() {
//        this.numOfLevels = (int) (Math.log(numOfElements) / Math.log(2));
        numOfLevels = 5;
        initializeLevels();
    }

    private void initializeLevels() {
        levels = new Level[numOfLevels];
        for(int i=0; i < this.numOfLevels; i++) {
            levels[i] = new Level<>(i);
            if(i != 0) {
                levels[i].start.lower = levels[i-1].start;
                levels[i].end.lower = levels[i-1].end;
            }
        }
    }

    private int flipACoin() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public Node<T> search(T key) {
        Node<T> predecessor = floor(key);
        if(predecessor.data.equals(key)) {
            return predecessor;
        } else {
            return null;
        }
    }

    private Node<T> floor(T key) {
        int currLevel = numOfLevels - 1;
        Node<T> p = levels[currLevel].start;
        while (true) {
            if (p.next == levels[currLevel].end || p.next.data.compareTo(key) >= 0){
                if(p.lower == null) {
                    return p;
                }
                p = p.lower;
                currLevel -= 1;
            } else {
                p = p.next;
            }
        }
    }

    private ArrayList<Node<T>> predecessors(T key) {
        ArrayList<Node<T>> preds = new ArrayList<>();
        int currLevel = numOfLevels - 1;
        Node<T> p = levels[currLevel].start;
        while (true) {
             if (p.next == levels[currLevel].end || p.next.data.compareTo(key) >= 0){
                preds.add(p);
                if(p.lower != null) {
                    p = p.lower;
                    currLevel -= 1;
                } else {
                    break;
                }
            } else {
                p = p.next;
            }
        }
        return preds;
    }

    @Override
    public void insert(T key) {
        ArrayList<Node<T>> nodeList = predecessors(key);
        if(nodeList.get(nodeList.size() - 1).next.data == null || !nodeList.get(nodeList.size() - 1).next.data.equals(key)) {
            Node<T> lower = null;
            Node<T> newNode = new Node<>(key);
            Node<T> curr = nodeList.get(nodeList.size() - 1);
            newNode.next = curr.next;
            curr.next = newNode;
            newNode.lower = lower;
            lower = newNode;
            for (int i = nodeList.size() - 2; i >= 0; i--) {
                if(flipACoin() == 1) {
                    newNode = new Node<>(key);
                    curr = nodeList.get(i);
                    newNode.next = curr.next;
                    curr.next = newNode;
                    newNode.lower = lower;
                    lower = newNode;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void delete(T key) throws ElementNotFoundException {
        ArrayList<Node<T>> nodeList = predecessors(key);
        if(nodeList.get(nodeList.size() - 1).next.data == null || !nodeList.get(nodeList.size() - 1).next.data.equals(key)) {
            throw new ElementNotFoundException();
        } else {
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                Node<T> curr = nodeList.get(i);
                if (curr.next.data != null && curr.next.data.equals(key)) {
                    curr.next = curr.next.next;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void ascendingOrder() {
        Level<T> zeroLevel = levels[0];
        Node<T> p = zeroLevel.start.next;
        while (p != zeroLevel.end) {
            System.out.println(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    public void printSkipList() {
        for(int i = numOfLevels - 1; i>=0; i--) {
            System.out.print("Level " + i + ": ");
            Level<T> currLevel = levels[i];
            Node<T> p = currLevel.start.next;
            while (p != currLevel.end) {
                System.out.print(p.data+" ");
                p = p.next;
            }
            System.out.println();
        }
    }
}
