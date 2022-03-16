package array.algo_company.Threading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String... args) {

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        try {
            //schedule to run after sometime
            System.out.println("Current Time = " + new Date());
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                WorkThread worker = new WorkThread("do heavy processing");
               // scheduledThreadPool.schedule(worker, 20, TimeUnit.SECONDS);

               // scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10, TimeUnit.SECONDS);

                scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 2, TimeUnit.SECONDS);
            }

            //add some delay to let some threads spawn by scheduler

            Thread.sleep(30000);


            scheduledThreadPool.shutdown();
            while (!scheduledThreadPool.isTerminated()) {
                //wait for all tasks to finish
            }
            System.out.println("Finished all threads");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
