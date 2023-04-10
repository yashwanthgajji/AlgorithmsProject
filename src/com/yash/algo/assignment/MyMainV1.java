package com.yash.algo.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMainV1 {

    public static void main(String[] args) {
//        calculateForIntegerData(args);
//        calculateForDoubleData(args);
//        calculateForStringData(args);
    }

    private static void calculateForIntegerData(String[] args) {
        DataStructureV1<Integer> dataStructureV1 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> dataStructureV1 = new HashTable<>();
                case 1 -> dataStructureV1 = new BinarySearchTree<>();
                case 2 -> dataStructureV1 = new SplayTree<>();
                case 3 -> dataStructureV1 = new SkipList<>();
//                case 4 -> dataStructure = new RedBlackTree();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV1 != null) {
                dataStructureV1.getClass().componentType();
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
                case 0 -> dataStructureV1 = new HashTable<>();
                case 1 -> dataStructureV1 = new BinarySearchTree<>();
                case 2 -> dataStructureV1 = new SplayTree<>();
                case 3 -> dataStructureV1 = new SkipList<>();
//                case 4 -> dataStructure = new RedBlackTree();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV1 != null) {
                dataStructureV1.getClass().componentType();
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
                case 0 -> dataStructureV1 = new HashTable<>();
                case 1 -> dataStructureV1 = new BinarySearchTree<>();
                case 2 -> dataStructureV1 = new SplayTree<>();
                case 3 -> dataStructureV1 = new SkipList<>();
//                case 4 -> dataStructure = new RedBlackTree();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV1 != null) {
                dataStructureV1.getClass().componentType();
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
            } else {
                System.out.println("Enter correct Data Structure");
            }
        }
    }

}
