import java.util.Random;

public class Array {
    private int size = 10;
    private int[] array;

    public Array() {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
    }

    public Array(int arraySize) {
        this.size = arraySize;
        array = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
    }

    public Array(int[] array) {
        this.size = array.length;
        this.array = new int[size];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public int get(int index) {
        return this.array[index];
    }

    public void reverse() {
        for (int i = 0; i < this.size / 2; i++) {
            int a = this.array[this.size - 1 - i];
            this.array[this.size - 1 - i] = this.array[i];
            this.array[i] = a;
        }
    }

    public void printArray() {
        for (int i = 0; i < this.size - 1; i++) {
            System.out.print(this.array[i] + ", ");
        }
        System.out.println(this.array[this.size - 1]);
    }

    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                int a = array[j]; //swap
                array[j] = array[j + 1];
                array[j + 1] = a;
                j--;
            }
        }
    }

    public static void insertionSort(int[] array) {
        Array a = new Array(array);
        a.insertionSort();
        for (int i = 0; i < array.length; i++) {
            array[i] = a.get(i);
        }
    }
}