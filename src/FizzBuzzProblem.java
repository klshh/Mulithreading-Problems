import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzProblem {

    private int n;
    private Semaphore numberSemaphore;
    private Semaphore fizzSemaphore;
    private Semaphore buzzSemaphore;
    private Semaphore fizzBuzzSemaphore;


    public FizzBuzzProblem(int n) {
        this.n = n;
        this.numberSemaphore = new Semaphore(1);
        this.fizzSemaphore = new Semaphore(0);
        this.buzzSemaphore = new Semaphore(0);
        this.fizzBuzzSemaphore = new Semaphore(0);
    }

    public void number(IntConsumer number) throws InterruptedException{

        for(int i = 1 ;i <= n;i++){
            numberSemaphore.acquire();

            if(i % 3 == 0 && i % 5 == 0) {
                fizzBuzzSemaphore.release();
            } else if(i % 3 == 0) {
                fizzSemaphore.release();
            } else if(i % 5 == 0) {
                buzzSemaphore.release();
            } else {
                number.accept(i);
                numberSemaphore.release();
            }
        }

    }

    public void fizz(Runnable fizz) throws InterruptedException{

            for(int i = 1 ;i <= n;i++){
                if(i % 3 == 0 && i % 5 != 0){
                    fizzSemaphore.acquire();
                    fizz.run();
                    numberSemaphore.release();
                }
            }

    }

    public void buzz(Runnable buzz) throws InterruptedException{

        for(int i = 1 ;i <= n;i++){
            if(i % 3 != 0 && i % 5 == 0){
                buzzSemaphore.acquire();
                buzz.run();
                numberSemaphore.release();
            }
        }

    }

    public void fizzBuzz(Runnable buzzFizz) throws InterruptedException{

        for(int i = 1 ;i <= n;i++){
            if(i % 3 == 0 && i % 5 == 0){
                fizzBuzzSemaphore.acquire();
                buzzFizz.run();
                numberSemaphore.release();
            }
        }

    }
}
