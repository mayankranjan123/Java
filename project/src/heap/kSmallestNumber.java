package heap;

import java.util.PriorityQueue;

public class kSmallestNumber {
    public static void main(String[] args) {
        int a[] = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println("3rd Smallest Number: " + kSmallest(a, a.length, 3));

    }

    private static int kSmallest(int[] a, int length, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Integer i : a)
            heap.add(i);

        int size = heap.size();

        int newArray [] = new int[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = heap.poll();
        }
        return newArray[k - 1];
    }
}
