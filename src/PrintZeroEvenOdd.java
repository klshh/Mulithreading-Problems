import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore;
    private Semaphore evenSemaphore;
    private Semaphore oddSemaphore;

    public PrintZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
        oddSemaphore = new Semaphore(0);
    }

    public void zero(IntConsumer number) throws InterruptedException {
        boolean isOdd = true;

        for(int i = 1; i <= n; i++){
            zeroSemaphore.acquire();
            number.accept(0);

            if(isOdd){
                oddSemaphore.release();
            }else {
                evenSemaphore.release();
            }

            isOdd = !isOdd;
        }
    }

    public void even(IntConsumer number) throws InterruptedException {

        for(int i = 2; i <= n; i+= 2){
            evenSemaphore.acquire();
            number.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer number) throws InterruptedException {

        for(int i = 1; i <= n; i+=2){
            oddSemaphore.acquire();
            number.accept(i);
            zeroSemaphore.release();
        }


    }
}
