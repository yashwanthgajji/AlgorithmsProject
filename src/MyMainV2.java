import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMainV2 {

    public static void main(String[] args) {
        calculateForIntegerData(args);
//        calculateForDoubleData(args);
//        calculateForStringData(args);
    }

    private static void calculateForIntegerData(String[] args) {
        DataStructureV2<Integer> dataStructureV2 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> System.out.println("""
                        HashTable is not there for Version 2
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
                case 1 -> dataStructureV2 = new BinarySearchTreeV2<>();
                case 2 -> dataStructureV2 = new SplayTreeV2<>();
                case 3 -> System.out.println("""
                        SkipList is not there for Version 2
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
                case 4 -> dataStructureV2 = new RedBlackTreeV2<>();
                default -> System.out.println("""
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
            }
            if (dataStructureV2 != null) {
                File file = new File(inputFileName);
                int lineNumber = 0;
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        lineNumber++;
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV2.insert(Integer.valueOf(key));
                        } else {
                            dataStructureV2.delete(Integer.valueOf(key));
                        }
                        System.out.println("Height of the tree: " + dataStructureV2.height());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                } catch (ElementNotFoundException e) {
                    try {
                        throw new ElementNotFoundException(lineNumber);
                    } catch (ElementNotFoundException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

    private static void calculateForDoubleData(String[] args) {
        DataStructureV2<Double> dataStructureV2 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> System.out.println("""
                        HashTable is not there for Version 2
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
                case 1 -> dataStructureV2 = new BinarySearchTreeV2<>();
                case 2 -> dataStructureV2 = new SplayTreeV2<>();
                case 3 -> System.out.println("""
                        SkipList is not there for Version 2
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
                case 4 -> dataStructureV2 = new RedBlackTreeV2<>();
                default -> System.out.println("""
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
            }
            if (dataStructureV2 != null) {
                File file = new File(inputFileName);
                int lineNumber = 0;
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        lineNumber++;
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV2.insert(Double.valueOf(key));
                        } else {
                            dataStructureV2.delete(Double.valueOf(key));
                        }
                        System.out.println("Height of the tree: " + dataStructureV2.height());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                } catch (ElementNotFoundException e) {
                    try {
                        throw new ElementNotFoundException(lineNumber);
                    } catch (ElementNotFoundException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

    private static void calculateForStringData(String[] args) {
        DataStructureV2<String> dataStructureV2 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
                case 0 -> System.out.println("""
                        HashTable is not there for Version 2
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
                case 1 -> dataStructureV2 = new BinarySearchTreeV2<>();
                case 2 -> dataStructureV2 = new SplayTreeV2<>();
                case 3 -> System.out.println("""
                        SkipList is not there for Version 2
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
                case 4 -> dataStructureV2 = new RedBlackTreeV2<>();
                default -> System.out.println("""
                        Enter the correct value for Data Structure
                        1. Binary Search Tree
                        2. Splay Tree
                        4. Red Black Tree
                        """);
            }
            if (dataStructureV2 != null) {
                File file = new File(inputFileName);
                int lineNumber = 0;
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        lineNumber++;
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV2.insert(key);
                        } else {
                            dataStructureV2.delete(key);
                        }
                        System.out.println("Height of the tree: " + dataStructureV2.height());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                } catch (ElementNotFoundException e) {
                    try {
                        throw new ElementNotFoundException(lineNumber);
                    } catch (ElementNotFoundException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

}
