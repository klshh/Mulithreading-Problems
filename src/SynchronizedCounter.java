public class SynchronizedCounter {
    private int count = 0;


    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Runnable task = () -> {
            for(int i = 0; i < 1000 ; i++){
                synchronizedCounter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Final value of counter: " + synchronizedCounter.count);

    }
}
