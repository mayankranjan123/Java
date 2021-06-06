package roundtwo;

public class QuickSort {
    public static void main(String[] args) {
        int a[] = new int[] {7, 2, 1, 6, 8, 5, 3, 4};
        quicksort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    private static void quicksort(int[] a, int start, int end) {
        if (start < end) {
            int pIndex = partition(a, start, end);
            quicksort(a, start,pIndex - 1);
            quicksort(a, pIndex + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pIndex = start, pivot = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex ++;
            }
        }
        int temp = a[pIndex];
        a[pIndex] = a[end] ;
        a[end] = temp;
        return pIndex;
    }
}
