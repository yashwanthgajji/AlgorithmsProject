package com.yash.algo.assignment;

import com.yash.algo.assignment.bst.BinarySearchTree;
import com.yash.algo.assignment.rbtree.RedBlackTree;
import com.yash.algo.assignment.skiplist.SkipList;
import com.yash.algo.assignment.splaytree.SplayTree;
import com.yash.algo.assignment.temp.Car;

public class Main {

    public static void main(String[] args) {

//        Car<Integer> car1 = new Car<Integer>("Camry", 293393934, 102929383, 8938822, 2345686);
//        System.out.println(car1.toString());
//        Car<Double> car2 = new Car<Double>("Camry", 293393934, 102929383.0000, 8938822.256, 8938822.650);
//        System.out.println(car2.toString());
//        Car<String> car3 = new Car<String>("Camry", 293393934, "102929383", "8938822", "2345686");
//        System.out.println(car3.toString());

//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        bst.insert(6);
//        bst.inorder();
//        bst.insert(3);
//        bst.inorder();
//        bst.insert(5);
//        bst.inorder();
//        bst.insert(4);
//        bst.inorder();
//        bst.insert(1);
//        bst.inorder();
//        bst.insert(8);
//        bst.inorder();
//        bst.insert(7);
//        bst.inorder();
//        try {
//            bst.delete(6);
//        } catch (ElementNotFoundException e) {
//            e.printStackTrace();
//        }
//        bst.inorder();
//        try {
//            bst.delete(9);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }

//        BinarySearchTree<String> bstString = new BinarySearchTree<>();
//        bstString.insert("Hello");
//        bstString.inorder();
//        bstString.insert("World");
//        bstString.inorder();
//        bstString.insert("World");
//        bstString.inorder();
//        try {
//            bstString.delete("Hello");
//        } catch (ElementNotFoundException e) {
//            e.printStackTrace();
//        }
//        bstString.inorder();
//        try {
//            bstString.delete("Hi");
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }

//        SkipList<Integer> skipList = new SkipList<>(10);
//        System.out.println("Inserting 8");
//        skipList.insert(8);
//        skipList.printSkipList();
//        System.out.println("Inserting 5");
//        skipList.insert(5);
//        skipList.printSkipList();
//        System.out.println("Inserting 5");
//        skipList.insert(5);
//        skipList.printSkipList();
//        System.out.println("Inserting 1");
//        skipList.insert(1);
//        skipList.printSkipList();
//        System.out.println("Inserting 7");
//        skipList.insert(7);
//        skipList.printSkipList();
//        System.out.println("Inserting 9");
//        skipList.insert(9);
//        skipList.printSkipList();
//        System.out.println("Inserting 9");
//        skipList.insert(9);
//        skipList.printSkipList();
//        System.out.println("Inserting 0");
//        skipList.insert(0);
//        skipList.printSkipList();
//        System.out.println("Inserting 4");
//        skipList.insert(4);
//        skipList.printSkipList();
//        System.out.println("Inserting 6");
//        skipList.insert(6);
//        skipList.printSkipList();
//        System.out.println("Inserting 3");
//        skipList.insert(3);
//        skipList.printSkipList();
//        System.out.println("Inserting 3");
//        skipList.insert(3);
//        skipList.printSkipList();
//        System.out.println("Inserting 2");
//        skipList.insert(2);
//        skipList.printSkipList();
//        System.out.println("Deleting 0");
//        try {
//            skipList.delete(0);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
//        skipList.printSkipList();
//        System.out.println("Deleting 3");
//        try {
//            skipList.delete(3);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
//        skipList.printSkipList();
//        System.out.println("Deleting 9");
//        try {
//            skipList.delete(9);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
//        skipList.printSkipList();
//        System.out.println("Deleting -10");
//        try {
//            skipList.delete(-10);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }

        SkipList<String> skipListString = new SkipList<>(5);
        skipListString.insert("Hello String");
        skipListString.printSkipList();
        skipListString.insert("I know it");
        skipListString.printSkipList();
        skipListString.insert("I know it");
        skipListString.printSkipList();
        skipListString.insert("You are it");
        skipListString.printSkipList();
        try {
            skipListString.delete("I know it");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        skipListString.printSkipList();
        skipListString.insert("Hello Strong");
        skipListString.printSkipList();
        skipListString.insert("A wood pecker got killed");
        skipListString.printSkipList();
    }
}
