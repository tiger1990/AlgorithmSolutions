package array.algo_company.Threading;

public class InterThreadCommunication
{
    static class Data
    {
        int num =0;
        boolean dataAvailable = false;

        synchronized void  produce(int number)
        {
            while(dataAvailable)
            {
                try
                {
                    wait();
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            this.num = number;
            System.out.println("Produced :: "+num);
            dataAvailable = true;
            notify();
        }

        synchronized void  consume()
        {
            while(!dataAvailable)
            {
                try
                {
                    wait();
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            System.out.println("Consumed :: "+num +"\n");
            dataAvailable = false;
            notify();
        }
    }

   static class Producer implements Runnable
    {
        Data data;

        public Producer(Data data)
        {
           this.data = data;
           new Thread(this,"Producer").start();
        }

        @Override
        public void run()
        {
            int number =0;

            while(true)
            {
                data.produce(number++);
                try
                {
                    Thread.sleep(1000);
                }catch(Exception ex){}
            }
        }
    }

    static class Consumer implements Runnable
    {
        Data data;

        public Consumer(Data data)
        {
            this.data = data;
            new Thread(this,"Consumer").start();
        }

        @Override
        public void run()
        {
            while(true)
            {
                data.consume();
                try
                {
                    Thread.sleep(1000);
                }catch(Exception ex){}
            }
        }
    }


    public static void main(String... args)
    {
        Data data = new Data();
        new Producer(data);
        new Consumer(data);
    }
}
