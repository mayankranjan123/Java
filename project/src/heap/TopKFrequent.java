package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        int arr[] = new int[] {8, 10, 7, 8, 10, 1, 8};
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
        maxHeap.addAll(map.entrySet());

        int k = 0;
        for (Map.Entry<Integer, Integer> m : maxHeap) {
            if (k >= 2) {
                break;
            }
            System.out.println(m.getKey());
            k++;
        }



    }
}
