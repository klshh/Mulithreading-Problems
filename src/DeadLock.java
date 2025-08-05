import java.util.Objects;

public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            synchronized (lock1){
                System.out.println("Thread 1 hold lock1");
                    synchronized (lock2){
                        System.out.println("Thread 1 hold lock 2");
                    }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2){
                System.out.println("Thread 2 hold lock 1");
                synchronized (lock1){
                    System.out.println("Thread 2 hold lock 2");
                }
            }

        }).start();
    }
}
