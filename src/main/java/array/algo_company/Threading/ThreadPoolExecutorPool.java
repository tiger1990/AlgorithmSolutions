package array.algo_company.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorPool {

    public static void main(String... args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for(int i=0; i<10 ; i++)
        {
            WorkThread thread = new WorkThread(""+i);

            executorService.submit(thread);
        }
        executorService.shutdown();
        while(!executorService.isShutdown()){}
    }
}

