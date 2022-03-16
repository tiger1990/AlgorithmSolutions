package array.algo_company.Threading.blockingque;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    protected BlockingQueue<Integer> queue = null;
    private final Integer POISON;

    public Consumer(BlockingQueue blockingQueue, Integer poision)
    {
        queue = blockingQueue;
        POISON = poision;
    }

    @Override
    public void run() {

        try
        {
            while (true)
            {
                Integer value = queue.take();
                System.out.println("Consumed::" + value);
                if(value == POISON)
                {
                    break;
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
