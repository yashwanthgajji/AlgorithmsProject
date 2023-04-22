import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMainV1 {

    public static void main(String[] args) {
        double startTime = System.nanoTime();
        calculateForIntegerData(args);
//        calculateForDoubleData(args);
//        calculateForStringData(args);
        double stopTime = System.nanoTime();
        System.out.println("Time taken is : " + (stopTime - startTime)/1000000.0 + " milliseconds\n");
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
                default -> System.out.println("""
                        Enter the correct value for Data Structure
                        0. Hash Table
                        1. Binary Search Tree
                        2. Splay Tree
                        3. Skip List
                        4. Red Black Tree""");
            }
            if (dataStructureV1 != null) {
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
                            dataStructureV1.insert(Integer.valueOf(key));
                        } else {
                            dataStructureV1.delete(Integer.valueOf(key));
                        }
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
                dataStructureV1.ascendingOrder();
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
                default -> System.out.println("""
                        Enter the correct value for Data Structure
                        0. Hash Table
                        1. Binary Search Tree
                        2. Splay Tree
                        3. Skip List
                        4. Red Black Tree""");
            }
            if (dataStructureV1 != null) {
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
                            dataStructureV1.insert(Double.valueOf(key));
                        } else {
                            dataStructureV1.delete(Double.valueOf(key));
                        }
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
                dataStructureV1.ascendingOrder();
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
                default -> System.out.println("""
                        Enter the correct value for Data Structure
                        0. Hash Table
                        1. Binary Search Tree
                        2. Splay Tree
                        3. Skip List
                        4. Red Black Tree""");
            }
            if (dataStructureV1 != null) {
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
                            dataStructureV1.insert(key);
                        } else {
                            dataStructureV1.delete(key);
                        }
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
                dataStructureV1.ascendingOrder();
            }
        }
    }

}
