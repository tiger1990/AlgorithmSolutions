package array.algo_company.Threading;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

public class FutureImplementation
{

   public static void main(String... args)
   {
       ExecutorService executorService = Executors.newFixedThreadPool(10);

       ArrayList<Future<String>> listFuture = new ArrayList<>();

       Callable<String> callable = new MyCallable(1000);

       for(int i=0; i< 100; i++){
           //submit Callable tasks to be executed by thread pool
           Future<String> future = executorService.submit(callable);
           //add Future to the list, we can get return value using Future
           listFuture.add(future);
       }


       for(Future future:listFuture)
       {
           try
           {
               System.out.println(new Date()+""+future.get());

           }catch (InterruptedException | ExecutionException exe)
           {

           }
       }
       executorService.shutdown();
   }
}
