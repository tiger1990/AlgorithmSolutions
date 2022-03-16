package array.algo_company.Threading;

public class WorkThread implements Runnable {

    String command;

    public WorkThread(String command) {

        this.command = command;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " Command::=" + command);

        processCommand();

        System.out.println(Thread.currentThread().getName() + " Command::=" + "END");
    }

    private void processCommand() {

        try {
            Thread.sleep(500);

        } catch (InterruptedException ex) {
        }
    }

    @Override
    public String toString() {
        return command;
    }
}