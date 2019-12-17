import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.init();
        app.start();
    }

    // Some app resources
    public Scanner inputScanner;
    public Array array;
    public int arraySize;

    // Some app properties
    public final String[] COMMAND_NAMES = {"exit", "help", "createArray", "readArray", "sortArray"};

    /**
     * Initialization function.
     */
    public void init() {
        inputScanner = new Scanner(System.in);
        array = null;
        arraySize = 0;
    }

    /**
     * Main running method.
     */
    public void start() {
        while (true) {
            System.out.println("\nPlease input command.");
            String command = inputScanner.nextLine().trim();
            switch (command) {
                case "exit":
                    System.exit(0);
                    break;
                case "help":
                    runHelp();
                    break;
                case "createArray":
                    createArray();
                    break;
                case "readArray":
                    showArray();
                    break;
                case "sortArray":
                    sortArray();
                    break;
                default:
                    System.out.println("Unknown command");
                    runHelp();
                    break;
            }
        }
    }

    private void runHelp() {
        System.out.println("Commands that can be ran: " + Arrays.toString(COMMAND_NAMES));
        System.out.println("exit        - shut down the program");
        System.out.println("help        - print a list of available commands");
        System.out.println("createArray - create a new array");
        System.out.println("readArray   - print array elements");
        System.out.println("sortArray   - sort array in ascending order");
    }

    private void createArray() {
        System.out.println("Enter the number of elements in the array");
        arraySize = Integer.parseInt(inputScanner.nextLine());
        System.out.println("Enter 1 if you want to fill the array with random elements");
        System.out.println("Enter 2 if you want to fill the array with your elements");
        int n = Integer.parseInt(inputScanner.nextLine());
        boolean flag = true;
        while (flag) {
            switch (n) {
                case 1:
                    array = new Array(arraySize);
                    flag = false;
                    break;
                case 2:
                    int[] a = new int[arraySize];
                    System.out.println("Enter array elements with a space:");
                    for (int i = 0; i < a.length; i++) {
                        a[i] = inputScanner.nextInt();
                    }
                    array = new Array(a);
                    flag = false;
                    break;
                default:
                    System.out.println("You entered an invalid number. Re-enter the number");
                    break;
            }
        }
    }

    private void showArray() {
        if (array == null) {
            System.out.println("Array not created. Use command createArray");
        }
        else {
            array.printArray();
        }
    }

    private void sortArray() {
        if (array == null) {
            System.out.println("Array not created. Use command createArray");
        }
        else {
            array.insertionSort();
        }
    }
}