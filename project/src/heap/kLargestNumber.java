package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kLargestNumber {
    public static void main(String[] args) {
        int a[] = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println("1st Largest Number: " + kLargest(a, a.length, 1));

    }

    private static int kLargest(int[] a, int length, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer i : a)
            maxHeap.add(i);

        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = maxHeap.poll();
        }
        return newArray[k - 1];
    }
}
