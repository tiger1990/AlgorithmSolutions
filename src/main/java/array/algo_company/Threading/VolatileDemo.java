package array.algo_company.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileDemo {

    public static void main(String[] args) {
        Data data = new Data();
        // Starting 6 threads
        ExecutorService ex = Executors.newFixedThreadPool(6);
        ex.execute(new VTask(data));
        ex.execute(new VTask(data));
        ex.execute(new VTask(data));
        ex.execute(new VTask(data));
        ex.execute(new VTask(data));
        ex.execute(new VTask(data));
        //shutting down the executor service
        ex.shutdown();
    }
}

//Volatile does not gaurentee atomicity in multithreaded environment

//volatile variables are not cached and read operation on a
// volatile variable always returns the most recent write by any thread.

// shared class
class Data {
    public volatile int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ++counter;
    }
}

// Thread 
class VTask implements Runnable {
    private Data data;

    public VTask(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Value for Thread " + Thread.currentThread().getName() +
                " Before increment " + data.getCounter());
        data.incrementCounter();
        System.out.println("Value for Thread " + Thread.currentThread().getName() +
                " After increment " + data.getCounter());

    }
}