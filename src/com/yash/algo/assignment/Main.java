package com.yash.algo.assignment;

import com.yash.algo.assignment.V1.DataStructureV1;
import com.yash.algo.assignment.V1.RedBlackTreeV1;
import com.yash.algo.assignment.V1.SkipListV1;
import com.yash.algo.assignment.V1.SplayTreeV1;
import com.yash.algo.assignment.V2.BinarySearchTreeV2;
import com.yash.algo.assignment.V2.DataStructureV2;
import com.yash.algo.assignment.V2.RedBlackTreeV2;
import com.yash.algo.assignment.V2.SplayTreeV2;

public class Main {

    public static void main(String[] args) throws ElementNotFoundException {

//        Car<Integer> car1 = new Car<Integer>("Camry", 293393934, 102929383, 8938822, 2345686);
//        System.out.println(car1.toString());
//        Car<Double> car2 = new Car<Double>("Camry", 293393934, 102929383.0000, 8938822.256, 8938822.650);
//        System.out.println(car2.toString());
//        Car<String> car3 = new Car<String>("Camry", 293393934, "102929383", "8938822", "2345686");
//        System.out.println(car3.toString());

        DataStructureV2<Integer> bst = new SplayTreeV2<>();
        bst.insert(6);
        System.out.println(bst.height());
        bst.insert(3);
        System.out.println(bst.height());
        bst.insert(5);
        System.out.println(bst.height());
        bst.insert(4);
        System.out.println(bst.height());
        bst.insert(1);
        System.out.println(bst.height());
        bst.insert(8);
        System.out.println(bst.height());
        bst.insert(7);
        System.out.println(bst.height());
        try {
            bst.delete(6);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(bst.height());
        try {
            bst.delete(9);
        } catch (ElementNotFoundException e) {
            throw new ElementNotFoundException(9);
        }
        System.out.println(bst.height());
        bst.insert(7);
        System.out.println(bst.height());

        DataStructureV1<String> bstString = new SplayTreeV1<>();
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

//        RedBlackTreeV1<String> skipListString = new RedBlackTreeV1<>();
//        skipListString.insert("Hello String");
//        skipListString.ascendingOrder();
//        skipListString.insert("I know it");
//        skipListString.ascendingOrder();
//        skipListString.insert("I know it");
//        skipListString.ascendingOrder();
//        skipListString.insert("You are it");
//        skipListString.ascendingOrder();
//        try {
//            skipListString.delete("I know it");
//        } catch (ElementNotFoundException e) {
//            e.printStackTrace();
//        }
//        skipListString.ascendingOrder();
//        skipListString.insert("Hello Strong");
//        skipListString.ascendingOrder();
//        skipListString.insert("A wood pecker got killed");
//        skipListString.ascendingOrder();
    }
}
