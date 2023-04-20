package com.yash.algo.assignment;

import com.yash.algo.assignment.V1.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMainV1 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
//        calculateForIntegerData(args);
//        calculateForDoubleData(args);
//        calculateForStringData(args);
        long stopTime = System.nanoTime();
        System.out.println("Time taken is : " + (stopTime - startTime));
    }

    private static void calculateForIntegerData(String[] args) {
        DataStructureV1<Integer> dataStructureV1 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> dataStructureV1 = new HashTableV1<>();
                case 1 -> dataStructureV1 = new BinarySearchTreeV1<>();
                case 2 -> dataStructureV1 = new SplayTreeV1<>();
                case 3 -> dataStructureV1 = new SkipListV1<>();
                case 4 -> dataStructureV1 = new RedBlackTreeV1<>();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV1 != null) {
                File file = new File(inputFileName);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV1.insert(Integer.valueOf(key));
                        } else {
                            dataStructureV1.delete(Integer.valueOf(key));
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException | ElementNotFoundException e) {
                    e.printStackTrace();
                }
                dataStructureV1.ascendingOrder();
            } else {
                System.out.println("Enter correct Data Structure");
            }
        }
    }

    private static void calculateForDoubleData(String[] args) {
        DataStructureV1<Double> dataStructureV1 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> dataStructureV1 = new HashTableV1<>();
                case 1 -> dataStructureV1 = new BinarySearchTreeV1<>();
                case 2 -> dataStructureV1 = new SplayTreeV1<>();
                case 3 -> dataStructureV1 = new SkipListV1<>();
                case 4 -> dataStructureV1 = new RedBlackTreeV1<>();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV1 != null) {
                File file = new File(inputFileName);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV1.insert(Double.valueOf(key));
                        } else {
                            dataStructureV1.delete(Double.valueOf(key));
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException | ElementNotFoundException e) {
                    e.printStackTrace();
                }
                dataStructureV1.ascendingOrder();
            } else {
                System.out.println("Enter correct Data Structure");
            }
        }
    }

    private static void calculateForStringData(String[] args) {
        DataStructureV1<String> dataStructureV1 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> dataStructureV1 = new HashTableV1<>();
                case 1 -> dataStructureV1 = new BinarySearchTreeV1<>();
                case 2 -> dataStructureV1 = new SplayTreeV1<>();
                case 3 -> dataStructureV1 = new SkipListV1<>();
                case 4 -> dataStructureV1 = new RedBlackTreeV1<>();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV1 != null) {
                File file = new File(inputFileName);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV1.insert(key);
                        } else {
                            dataStructureV1.delete(key);
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException | ElementNotFoundException e) {
                    e.printStackTrace();
                }
                dataStructureV1.ascendingOrder();
            } else {
                System.out.println("Enter correct Data Structure");
            }
        }
    }

}
