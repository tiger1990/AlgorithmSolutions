package array.algo_company.Threading;

import java.util.concurrent.*;

public class WorkerPoolExample
{
    public static void main(String... args) throws InterruptedException
    {

        RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4, /*max 4 thread will run and 2 will be in blocking que (6,7,8,9 will be rejected)*/
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                threadFactory,
                rejectedExecutionHandler);

        MonitorThread monitorThreadRunnable = new MonitorThread(threadPoolExecutor,3);
        Thread monitorThread = new Thread(monitorThreadRunnable);
        monitorThread.start();

        //submit work to the thread pool
        for(int i=0; i<10; i++){
            threadPoolExecutor.execute(new WorkThread("cmd"+i));
        }

        Thread.sleep(30000);
        //shut down the pool
        threadPoolExecutor.shutdown();
        //shut down the monitor thread
        Thread.sleep(5000);
        monitorThreadRunnable.shutDown();
    }
}
