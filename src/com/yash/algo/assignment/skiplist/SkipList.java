package com.yash.algo.assignment.skiplist;

import com.yash.algo.assignment.ElementNotFoundException;

import java.util.ArrayList;
import java.util.Random;

public class SkipList {
    class Node {
        int data;
        Node next;
        Node lower;
        Node() {
            data = Integer.MAX_VALUE;
            next = null;
            lower = null;
        }
        Node(int key) {
            data = key;
            next = null;
            lower = null;
        }
    }

    class Level {
        int level;
        Node start;
        Node end;
        Level(int level) {
            this.level = level;
            start = new Node(Integer.MIN_VALUE);
            end = new Node(Integer.MAX_VALUE);
            start.next = end;
        }
    }

    private int numOfLevels;
    private Level levels[];

    public SkipList(int numOfElements) {
        this.numOfLevels = (int) (Math.log(numOfElements) / Math.log(2));
        initializeLevels(numOfLevels);
    }

    private void initializeLevels(int numOfLevels) {
        levels = new Level[this.numOfLevels];
        for(int i=0; i < numOfLevels; i++) {
            levels[i] = new Level(i);
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

    public Node search(int key) {
        Node predecessor = floor(key);
        if(predecessor.data == key) {
            return predecessor;
        } else {
            return null;
        }
    }

    private Node floor(int key) {
        int currLevel = numOfLevels - 1;
        Node p = levels[currLevel].start;
        while (true) {
            if (p.data == key) {
                while (p.lower != null) {
                    p = p.lower;
                    currLevel -= 1;
                    return p;
                }
            } else if (p.next == levels[currLevel].end || p.next.data > key){
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

    private ArrayList<Node> predecessors(int key) {
        ArrayList<Node> preds = new ArrayList<>();
        int currLevel = numOfLevels - 1;
        Node p = levels[currLevel].start;
        while (true) {
            if (p.next.data == key) {
                while (p != null) {
                    preds.add(p);
                    p = p.lower;
                    currLevel -= 1;
                }
                break;
            } else if (p.next == levels[currLevel].end || p.next.data > key){
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

    public void insert(int key) {
        ArrayList<Node> nodeList = predecessors(key);
        if(nodeList.get(nodeList.size() - 1).data != key) {
            Node lower = null;
            Node newNode = new Node(key);
            Node curr = nodeList.get(nodeList.size() - 1);
            newNode.next = curr.next;
            curr.next = newNode;
            newNode.lower = lower;
            lower = newNode;
            for (int i = nodeList.size() - 2; i >= 0; i--) {
                if(flipACoin() == 1) {
                    newNode = new Node(key);
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

    public void delete(int key) throws ElementNotFoundException {
        ArrayList<Node> nodeList = predecessors(key);
        if(nodeList.get(nodeList.size() - 1).next.data != key) {
            throw new ElementNotFoundException();
        } else {
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                Node curr = nodeList.get(i);
                if (curr.next.data == key) {
                    curr.next = curr.next.next;
                } else {
                    break;
                }
            }
        }
    }

    public void printList() {
        Level zeroLevel = levels[0];
        Node p = zeroLevel.start.next;
        while (p != zeroLevel.end) {
            System.out.println(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    public void printSkipList() {
        for(int i = numOfLevels - 1; i>=0; i--) {
            System.out.print("Level " + i + ": ");
            Level currLevel = levels[i];
            Node p = currLevel.start.next;
            while (p != currLevel.end) {
                System.out.print(p.data+" ");
                p = p.next;
            }
            System.out.println();
        }
    }
}
