package array.algo_company.Threading.blockingque;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    protected BlockingQueue<Integer> queue = null;
    private int startIndex = 0; private int mAxCapacity = 10;
    private final Integer POISON;

    public Producer(BlockingQueue blockingQueue, Integer poision)
    {
        queue = blockingQueue;
        POISON = poision;
    }

    @Override
    public void run() {
        try
        {
            process();
        }
        catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
        finally {
            while(true) {
                //try poison all consumer
                try {
                    queue.put(POISON);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void process() throws InterruptedException
    {
        while (queue.size() < mAxCapacity)
        {
            System.out.println("[Producer] Put : " + startIndex);
            queue.put(startIndex);
            System.out.println("[Producer] Queue remainingCapacity : " + queue.remainingCapacity());
            startIndex++;
        }
    }
}
