package multithread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();

        Thread t1 = new Thread(new Producer(sharedQueue));
        Thread t2 = new Thread(new Consumer(sharedQueue));
        t1.start();
        t2.start();
    }
}
