package multithread;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> sharedQueue;

    public Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
            synchronized (sharedQueue) {
                while (sharedQueue.isEmpty()) {
                    try {
                        System.out.println("Consumer is waiting for Producer to produce");
                        sharedQueue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int data = sharedQueue.poll();
                System.out.println("Consumed: " + data);
                sharedQueue.notify();
            }

        }
    }
