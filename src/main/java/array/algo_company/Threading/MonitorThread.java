package array.algo_company.Threading;

import java.util.concurrent.ThreadPoolExecutor;

public class MonitorThread  implements  Runnable {

    private ThreadPoolExecutor threadPoolExecutor;
    private int seconds;
    private boolean run = true;

    public MonitorThread(ThreadPoolExecutor threadPoolExecutor, int delay)
    {
       this.threadPoolExecutor = threadPoolExecutor;
       this.seconds = delay;
    }

    public void shutDown()
    {
       this.run = false;
    }


    @Override
    public void run() {

        while(run)
        {
                System.out.println(
                        String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",

                                this.threadPoolExecutor.getPoolSize(),
                                this.threadPoolExecutor.getCorePoolSize(),
                                this.threadPoolExecutor.getActiveCount(),
                                this.threadPoolExecutor.getCompletedTaskCount(),
                                this.threadPoolExecutor.getTaskCount(),
                                this.threadPoolExecutor.isShutdown(),
                                this.threadPoolExecutor.isTerminated()));

            try
            {
                Thread.sleep(seconds * 1000);

            }catch (InterruptedException ex){}
        }
    }
}
