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
//                case 0 -> dataStructureV2 = new HashTableV2<>();
                case 1 -> dataStructureV2 = new BinarySearchTreeV2<>();
                case 2 -> dataStructureV2 = new SplayTreeV2<>();
//                case 3 -> dataStructureV2 = new SkipListV1<>();
                case 4 -> dataStructureV2 = new RedBlackTreeV2<>();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV2 != null) {
                File file = new File(inputFileName);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV2.insert(Integer.valueOf(key));
                        } else {
                            dataStructureV2.delete(Integer.valueOf(key));
                        }
                        System.out.println(dataStructureV2.height());
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
        DataStructureV2<Double> dataStructureV2 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
//                case 0 -> dataStructureV2 = new HashTableV2<>();
                case 1 -> dataStructureV2 = new BinarySearchTreeV2<>();
                case 2 -> dataStructureV2 = new SplayTreeV2<>();
//                case 3 -> dataStructureV2 = new SkipListV2<>();
                case 4 -> dataStructureV2 = new RedBlackTreeV2<>();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV2 != null) {
                File file = new File(inputFileName);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV2.insert(Double.valueOf(key));
                        } else {
                            dataStructureV2.delete(Double.valueOf(key));
                        }
                        System.out.println(dataStructureV2.height());
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
        DataStructureV2<String> dataStructureV2 = null;
        if(args.length > 0) {
            int dataStructureSelector = Integer.parseInt(args[0]);
            String inputFileName = args[1];
            switch (dataStructureSelector) {
//                case 0 -> dataStructureV2 = new HashTableV2<>();
                case 1 -> dataStructureV2 = new BinarySearchTreeV2<>();
                case 2 -> dataStructureV2 = new SplayTreeV2<>();
//                case 3 -> dataStructureV2 = new SkipListV2<>();
                case 4 -> dataStructureV2 = new RedBlackTreeV2<>();
                default -> System.out.println("Enter the correct value for Data Structure");
            }
            if (dataStructureV2 != null) {
                File file = new File(inputFileName);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] inputs = data.split(" ", 2);
                        int operation = Integer.parseInt((inputs[0]));
                        String key = inputs[1];
                        if(operation == 1) {
                            dataStructureV2.insert(key);
                        } else {
                            dataStructureV2.delete(key);
                        }
                        System.out.println(dataStructureV2.height());
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
