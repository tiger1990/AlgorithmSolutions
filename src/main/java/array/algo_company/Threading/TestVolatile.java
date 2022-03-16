package array.algo_company.Threading;

public class TestVolatile {

   // private static  boolean flag = false; cause second thread deadlock

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        // implemented as anonymous inner class
        new Thread(new Runnable(){
            
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++){
                    System.out.println("printing value " + i);
                }
                flag = true;
            }
            
        }).start();
        
        // Implemented as lambda expression
        new Thread(()-> {
            int i = 1;
            while (!flag) i++;
            System.out.println("Job Done " + i);    
        }).start();
    }
}