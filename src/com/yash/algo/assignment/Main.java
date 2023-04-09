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

        BinarySearchTree<String> bstString = new BinarySearchTree<>();
        bstString.insert("Hello");
        bstString.inorder();
        bstString.insert("World");
        bstString.inorder();
        bstString.insert("World");
        bstString.inorder();
        try {
            bstString.delete("Hello");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        bstString.inorder();
        try {
            bstString.delete("Hi");
        } catch (ElementNotFoundException e) {
            System.out.println(e);
        }

//        SkipList skipList = new SkipList(10);
//        skipList.insert(8);
//        skipList.printSkipList();
//        skipList.insert(5);
//        skipList.printSkipList();
//        skipList.insert(1);
//        skipList.printSkipList();
//        skipList.insert(7);
//        skipList.printSkipList();
//        skipList.insert(9);
//        skipList.printSkipList();
//        skipList.insert(0);
//        skipList.printSkipList();
//        skipList.insert(4);
//        skipList.printSkipList();
//        skipList.insert(6);
//        skipList.printSkipList();
//        skipList.insert(3);
//        skipList.printSkipList();
//        skipList.insert(2);
//        skipList.printSkipList();
//        try {
//            skipList.delete(0);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
//        skipList.printSkipList();
//        try {
//            skipList.delete(6);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
//        skipList.printSkipList();
//        try {
//            skipList.delete(9);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
//        skipList.printSkipList();
//        try {
//            skipList.delete(-10);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e);
//        }
    }
}
