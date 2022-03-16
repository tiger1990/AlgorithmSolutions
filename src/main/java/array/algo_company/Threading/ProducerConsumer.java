package array.algo_company.Threading;

import java.util.Queue;

public class ProducerConsumer
{
    private int value = 0;
    private volatile boolean flag = false;

    public void produce(Queue<Integer> sharedListObj) {
        // while flag is true put thread to sleep
        while (flag) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sharedListObj.add(++value);
        System.out.println("Thread " + Thread.currentThread().getName() + " putting " + value);
        flag = true;
    }

    public int consume(Queue<Integer> sharedListObj) {
        int j = 0;
        while (!flag) j++;

        System.out.println("Getting from queue ");
        int value = sharedListObj.remove();
        flag = false;
        System.out.println("Thread " + Thread.currentThread().getName() + " Consuming " + value);
        return value;
    }
}