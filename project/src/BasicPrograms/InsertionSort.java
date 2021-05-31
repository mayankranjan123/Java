package BasicPrograms;

public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {4, 1, 3, 2};
        insertionSort(a);
        for (int i  = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void insertionSort(int[] a) {
        for (int i  = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i -1;

            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }

    }
}
