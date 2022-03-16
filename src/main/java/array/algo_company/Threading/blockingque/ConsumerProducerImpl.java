package array.algo_company.Threading.blockingque;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerImpl {

    private static int ThreshHold = 10;

    public static void main(String... args)
    {
        final Integer POISION = -1;

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(ThreshHold);
        new Thread(new Producer(blockingQueue,POISION)).start();
        new Thread(new Consumer(blockingQueue,POISION)).start();

    }
}
