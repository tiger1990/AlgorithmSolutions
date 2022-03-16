package array.algo_company.Threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
         Queue<Integer> sharedListObj = new LinkedList<Integer>();
         ProducerConsumer producerConsumer = new ProducerConsumer();
         new Thread(new Runnable() {
               
           @Override
           public void run() {
               for(int i = 0; i < 5; i++){
                   producerConsumer.produce(sharedListObj);
               }
           }
         }, "ProducerThread").start();
         
         new Thread(()-> {
             for(int i = 0; i < 5; i++){
                 producerConsumer.consume(sharedListObj);
             }
    
        }, "ConsumerThread").start();        
    }
}